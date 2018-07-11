/**
 * 
 */
package com.vyom.shipping.microservices.model;

/**
 * @author vyomr
 *
 */
public class Item {

	private Integer id;
	private String name;
	private String description;
	private Integer price;

	/**
	 * 
	 */
	public Item() {
	}

	/**
	 * @param id
	 * @param name
	 * @param description
	 * @param price
	 */
	public Item(Integer id, String name, String description, Integer price) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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
