/**
 * 
 */
package com.vyom.shipping.microservices.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * @author vyomr
 *
 */
@Entity
public class SalesOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id")
	private Long orderId;
	@Column(name = "order_description")
	private String orderDescription;
	@Column(name = "order_date")
	private Date orderDate;
	@Column(name = "email_id")
	private String emailId;
	@Column(name = "total_price")
	private Integer price;

	/**
	 * 
	 */
	public SalesOrder() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param orderId
	 * @param orderDescription
	 * @param orderDate
	 * @param emailId
	 * @param price
	 */
	public SalesOrder(Long orderId, String orderDescription, Date orderDate, String emailId, Integer price) {
		this.orderId = orderId;
		this.orderDescription = orderDescription;
		this.orderDate = orderDate;
		this.emailId = emailId;
		this.price = price;
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
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the price
	 */
	public Integer getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Integer price) {
		this.price = price;
	}

}
