/**
 * 
 */
package com.vyom.shipping.microservices.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.vyom.shipping.microservices.entity.OrderLineItem;
import com.vyom.shipping.microservices.entity.SalesOrder;
import com.vyom.shipping.microservices.model.CreateOrderRequest;
import com.vyom.shipping.microservices.model.Customer;
import com.vyom.shipping.microservices.model.Item;
import com.vyom.shipping.microservices.model.SalesOrderResponse;
import com.vyom.shipping.microservices.repository.OrderLineItemRepository;
import com.vyom.shipping.microservices.repository.SalesOrderRepository;
import com.vyom.shipping.microservices.service.CustomerService;
import com.vyom.shipping.microservices.service.ItemService;

/**
 * @author vyomr
 *
 */
@RestController
public class SalesOrderController {

	private static final Logger log = LoggerFactory.getLogger(SalesOrderController.class);

	@Autowired
	CustomerService customerService;

	@Autowired
	ItemService itemService;

	@Autowired
	SalesOrderRepository salesOrderRepository;

	@Autowired
	OrderLineItemRepository orderLineItemRepository;

	private static final String URL = "https://ms-item-service.herokuapp.com/api/item-service/items/";

	@PostMapping("/api/sales-order-service/order")
	public String createOrder(@RequestBody CreateOrderRequest body) {

		// Verify email address
		Customer verifiedCustomer = customerService.getCustomerDetail(body.getCustomerEmailId());
		if (verifiedCustomer != null && verifiedCustomer.getEmailId() != null) {
			log.info("Customer email address {} is verified", verifiedCustomer.getEmailId());
		} else {
			return body.getCustomerEmailId() + " could not be verified";
		}
		// get item details
		int totalPrice = 0;

		RestTemplate rest = new RestTemplate();
		ResponseEntity<Item[]> itemResponse = rest.getForEntity(URL + String.join(",", body.getItemNames()),
				Item[].class);

		// TODO: debug below line to check why feign is encoding url as
		// "/api/item/items/[Item1, Item3]"
		// Till then replacing below to use restTemplate.
		// List<Item> itemList = itemService.getItemDetail(body.getItemNames());
		if (itemResponse != null && !(Arrays.asList(itemResponse.getBody())).isEmpty()) {
			for (Item item : Arrays.asList(itemResponse.getBody())) {
				if (body.getItemNames().contains(item.getName())) {
					log.info("{} found and ready to be shipped", item.getName());
					totalPrice += item.getPrice();
				} else {
					log.info("{} not found", item.getName());
				}
			}
		}
		if (totalPrice == 0) {
			return "None of the Items ordered are currently in stock";
		}
		// save sales order table
		SalesOrder salesOrder = new SalesOrder();
		salesOrder.setEmailId(body.getCustomerEmailId());
		salesOrder.setOrderDate(body.getOrderDate());
		salesOrder.setOrderDescription(body.getOrderDescription());
		salesOrder.setPrice(totalPrice);

		log.info("Saving sales order :{}", salesOrder);
		SalesOrder savedSalesOrder = salesOrderRepository.saveAndFlush(salesOrder);

		// get orderid

		Long savedOrderId = savedSalesOrder.getOrderId();

		// save order-line-item table
		for (Item item : Arrays.asList(itemResponse.getBody())) {
			OrderLineItem orderLineItem = new OrderLineItem();
			orderLineItem.setName(item.getName());
			orderLineItem.setQuantity(1);
			orderLineItem.setOrderId(savedOrderId);
			log.info("Saving order line item :{}", orderLineItem);
			orderLineItemRepository.saveAndFlush(orderLineItem);
		}

		// return orderid
		return savedOrderId.toString();
	}

	@GetMapping("api/sales-order-service/orderId/{orderId}")
	public SalesOrderResponse getSalesOrderDetails(@PathVariable Long orderId) {
		Optional<SalesOrder> salesOrderEntity = salesOrderRepository.findById(orderId);
		List<String> itemList = orderLineItemRepository.findItemNamesByOrderId(orderId);
		SalesOrder saleOrder = new SalesOrder();
		if (salesOrderEntity.isPresent()) {
			saleOrder = salesOrderEntity.get();
		}

		return new SalesOrderResponse(orderId, saleOrder.getEmailId(), saleOrder.getOrderDescription(),
				saleOrder.getOrderDate(), saleOrder.getPrice(), itemList);
	}

}
