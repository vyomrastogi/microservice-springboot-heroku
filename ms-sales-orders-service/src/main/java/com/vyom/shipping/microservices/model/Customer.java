/**
 * 
 */
package com.vyom.shipping.microservices.model;


/**
 * @author vyomr
 *
 */
public class Customer {

	private String emailId;
	private String firstName;
	private String lastName;

	/**
	 * 
	 */
	public Customer() {
	}

	/**
	 * @param emailId
	 * @param firstName
	 * @param lastName
	 */
	public Customer(String emailId, String firstName, String lastName) {
		this.emailId = emailId;
		this.firstName = firstName;
		this.lastName = lastName;
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
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
