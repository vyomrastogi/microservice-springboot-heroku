package com.vyom.shipping.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.vyom.shipping.microservices")
public class MsSalesOrdersServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsSalesOrdersServiceApplication.class, args);
	}
}
