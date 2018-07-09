/**
 * 
 */
package com.vyom.shipping.microservices.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author vyomr
 *
 */
@Entity
public class OrderLineItem {
	
	@Id
	@GeneratedValue	
	@Column(name="id")
	private Long id;
	@Column(name="name")
	private String name;
	@Column(name="quantity")
	private Integer quantity;
	@Column(name="order_id")
	private Long orderId;
	/**
	 * 
	 */
	public OrderLineItem() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param name
	 * @param quantity
	 * @param orderId
	 */
	public OrderLineItem(Long id, String name, Integer quantity, Long orderId) {
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.orderId = orderId;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
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
	
	

}
