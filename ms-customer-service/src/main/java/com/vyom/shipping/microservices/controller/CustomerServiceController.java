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
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.vyom.shipping.microservices.config.DemoConfigs;
import com.vyom.shipping.microservices.entity.Customer;
import com.vyom.shipping.microservices.repository.CustomerRepository;

/**
 * @author vyomr
 *
 */
@RestController
@EnableHystrix
@RefreshScope
public class CustomerServiceController {

	private static final Logger log = LoggerFactory.getLogger(CustomerServiceController.class);

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	DemoConfigs config;

	@GetMapping("/api/customer-service/customers")
	@HystrixCommand(fallbackMethod = "fallbackGetCustomers")
	public List<Customer> getCustomers() {

		log.info("Retrieving list of available customers");
		List<Customer> returnCustomerList = customerRepository.findAll();
		log.info(String.format("Number of customers returned %s", returnCustomerList.size()));
		return returnCustomerList;

	}

	public List<Customer> fallbackGetCustomers() {
		log.error("Fallback triggered");
		Customer customer = new Customer("fallback@hystrix.com", "Fallback", "GetCustomers");
		List<Customer> customList = new ArrayList<Customer>();
		customList.add(customer);
		return customList;

	}

	@GetMapping("/api/customer-service/customers/email/{emailId}")
	@HystrixCommand(fallbackMethod = "fallbackGetCustomerDetail")
	public Customer getCustomerDetail(@PathVariable String emailId) {
		log.info(String.format("Retrieving  customer details for %s", emailId));
		Optional<Customer> customer = customerRepository.findById(emailId);
		Customer returnCustomer = new Customer();
		if (customer.isPresent()) {
			returnCustomer = customer.get();
		}
		return returnCustomer;

	}

	public Customer fallbackGetCustomerDetail(String emailId) {
		log.error("Fallback triggered");
		Customer customer = new Customer(emailId, "Fallback", "GetCustomers");
		return customer;

	}

	@GetMapping("/api/customer-service/fault-demo")
	@HystrixCommand(fallbackMethod = "fallBackDemo")
	public Customer getEmployeeDetailsFaultTolerance() {
		throw new RuntimeException("Fallback Demo");
	}

	public Customer fallBackDemo() {
		return new Customer(config.getEmailId(), config.getFirstName(), config.getLastName());
	}

}
