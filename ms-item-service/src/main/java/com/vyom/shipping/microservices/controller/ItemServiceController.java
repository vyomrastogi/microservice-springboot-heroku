/**
 * 
 */
package com.vyom.shipping.microservices.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.vyom.shipping.microservices.entity.Item;
import com.vyom.shipping.microservices.repository.ItemRepository;

/**
 * @author vyomr
 *
 */
@RestController
@EnableHystrix
public class ItemServiceController {

	private static final Logger log = LoggerFactory.getLogger(ItemServiceController.class);

	@Autowired
	ItemRepository itemRepository;

	@GetMapping("/api/item-service/items")
	@HystrixCommand(fallbackMethod = "fallbackGetItems")
	public List<Item> getItems() {

		log.info("Retrieving list of available items");
		List<Item> itemList = itemRepository.findAll();
		log.info(String.format("Number of items returned %s", itemList.size()));
		return itemList;

	}

	public List<Item> fallbackGetItems() {
		log.error("Fallback triggered");
		Item item = new Item(000,"Fallback","Fallback Description",000);
		List<Item> itemList = new ArrayList<Item>();
		itemList.add(item);
		return itemList;

	}

	@GetMapping("/api/item-service/items/{name}")
	@HystrixCommand(fallbackMethod = "fallbackGetItemsDetail")
	public List<Item> getItemDetail(@PathVariable List<String> name) {
		log.info(String.format("Retrieving  item details for %s", name));
		List<Item> itemList = itemRepository.findByNameIn(name);		
		return itemList;

	}

	public List<Item> fallbackGetItemsDetail(List<String> name) {
		log.error("Fallback triggered");
		Item item = new Item(000,"Fallback","Fallback Description",000);
		List<Item> itemList = new ArrayList<Item>();
		itemList.add(item);
		return itemList;


	}

}
