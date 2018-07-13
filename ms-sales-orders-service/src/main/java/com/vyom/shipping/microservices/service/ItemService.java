/**
 * 
 */
package com.vyom.shipping.microservices.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.vyom.shipping.microservices.model.Item;

/**
 * @author vyomr
 *
 */
@FeignClient(name="item-service",url="https://ms-item-service.herokuapp.com")
public interface ItemService {

	@GetMapping("/api/item-service/items/{name}")
	public List<Item> getItemDetail(@PathVariable List<String> name);

}
