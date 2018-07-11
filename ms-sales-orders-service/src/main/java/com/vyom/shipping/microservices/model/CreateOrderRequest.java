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
public class CreateOrderRequest {
	
	private String orderDescription;
	private Date orderDate;
	private String customerEmailId;
	private List<String> itemNames;
	
	
	
	/**
	 * 
	 */
	public CreateOrderRequest() {
		// TODO Auto-generated constructor stub
	}



	/**
	 * @param orderDescription
	 * @param orderDate
	 * @param customerEmailId
	 * @param itemNames
	 */
	public CreateOrderRequest(String orderDescription, Date orderDate, String customerEmailId, List<String> itemNames) {
		this.orderDescription = orderDescription;
		this.orderDate = orderDate;
		this.customerEmailId = customerEmailId;
		this.itemNames = itemNames;
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
