/**
 * 
 */
package com.vyom.shipping.microservices.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.vyom.shipping.microservices.model.Customer;


/**
 * @author vyomr
 *
 */
@FeignClient(name="customer-service",url="https://ms-customer-service.herokuapp.com")
public interface CustomerService {
	
	@GetMapping("/api/customer-service/customers/email/{emailId}")
	public Customer getCustomerDetail(@PathVariable String emailId);

}
