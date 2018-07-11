/**
 * 
 */
package com.vyom.shipping.microservices.model;

import java.util.Date;
import java.util.List;

/**
 * @author vyomr
 *
 */
public class SalesOrderResponse {

	private Long orderId;
	private String customerEmailId;
	private String orderDescription;
	private Date orderDate;
	private Integer totalPrice;
	private List<String> itemNames;

	/**
	 * 
	 */
	public SalesOrderResponse() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param orderId
	 * @param customerEmailId
	 * @param orderDescription
	 * @param orderDate
	 * @param totalPrice
	 * @param itemNames
	 */
	public SalesOrderResponse(Long orderId, String customerEmailId, String orderDescription, Date orderDate,
			Integer totalPrice, List<String> itemNames) {
		this.orderId = orderId;
		this.customerEmailId = customerEmailId;
		this.orderDescription = orderDescription;
		this.orderDate = orderDate;
		this.totalPrice = totalPrice;
		this.itemNames = itemNames;
	}

	/**
	 * @return the orderId
	 */
	public Long getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the customerEmailId
	 */
	public String getCustomerEmailId() {
		return customerEmailId;
	}

	/**
	 * @param customerEmailId the customerEmailId to set
	 */
	public void setCustomerEmailId(String customerEmailId) {
		this.customerEmailId = customerEmailId;
	}

	/**
	 * @return the orderDescription
	 */
	public String getOrderDescription() {
		return orderDescription;
	}

	/**
	 * @param orderDescription the orderDescription to set
	 */
	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}

	/**
	 * @return the orderDate
	 */
	public Date getOrderDate() {
		return orderDate;
	}

	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * @return the totalPrice
	 */
	public Integer getTotalPrice() {
		return totalPrice;
	}

	/**
	 * @param totalPrice the totalPrice to set
	 */
	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * @return the itemNames
	 */
	public List<String> getItemNames() {
		return itemNames;
	}

	/**
	 * @param itemNames the itemNames to set
	 */
	public void setItemNames(List<String> itemNames) {
		this.itemNames = itemNames;
	}

}
