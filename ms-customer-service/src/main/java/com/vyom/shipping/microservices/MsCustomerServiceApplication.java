package com.vyom.shipping.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsCustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCustomerServiceApplication.class, args);
	}
}
