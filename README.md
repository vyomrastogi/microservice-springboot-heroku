## A Case Study on Microservices with SpringBoot

The repository contains various project built to do a case study on "How to make microservices with Spring Boot? " 

-----------------------------------------------------------------------------------
### Concepts 

What is a Service ? 
> A piece of software to provide a particular functionality to different software/components in the application. ![Sample Service Flow](https://github.com/vyomrastogi/ms-online-shipping/blob/master/diag/sampleService.PNG)

What is a Microservice ?
> Some salient features of a microservice are : 
> * A service oriented architecture done well 
> * Efficiently scalable application
> * High performance application
> * Single service with a single focus/functionality to deliver
> * Technology agnostic API 
> * Lightweight communication
> * Independent data storage 
> * Independently changeable and deployable

What is the need for a Microservice ? 
> * To respond to required changes quickly or adapt rapidly
> * For reliability, as each microservice only has single functionality, they are less prone to errors
> * Automated CI/CD is easier with smaller components
> * On demand hosting technology like Cloud Foundry, Heroku, Azure, GCP 
> * Shorter development times
> * Decoupling of changeable parts
> * Faster issue resolutions

Characteristics of a Microservice 

| | | |
|-|-|-|
|Highly Cohesive (Single Focus)| Autonomous (Self reliable on serving requests) | Business Domain Driven
| Resiliency (able to serve with degraded func./ register -deregister) | Observable (monitoring, centralized logging) | Automation (CI/CD)

---

#### Technology Diagram

![Technology Stack](https://github.com/vyomrastogi/ms-online-shipping/blob/master/diag/technology_diag.png)


**TODO List**

- [X] add basic flow diagram
- [ ] add various components in each service
- [ ] show how zuul,config and discovery come into play
---

#### Tools/Frameworks Used 

1. **Spring Boot** - for rest api and various component development
	* Actuator - for application metrics
2. **Spring Cloud**
	* Cloud Config Server - for central configuration management
	* Cloud Config Client 
	* Spring Slueth - for tracing of various downstream calls, health metrics of service
	* Cloud Bus - for refreshing configuration without restart
	* Eureka Dicsovery - for API hearbeat registry
	* Zuul API Gateway - For API proxy
3. **Zipkin Server** - to view tracing data in timeline view 
4. **Heroku** - PAAS platform for deploying various applications 
5. **Travis** - For auto build and deploy from github
6. **LogDNA** - For centralized logging from heroku

---

#### Status 

|Service |Description|API|Development|CI/CD|
|--------|-----------|---|------|-----|
|customer-service| api to retrieve customer details| link| Completed|[![Build Status](https://travis-ci.com/vyomrastogi/customer-service.svg?branch=master)](https://travis-ci.com/vyomrastogi/customer-service)|
|item-service| api to retrieve item details like name, descp, cost etc.| link| Completed| [![Build Status](https://travis-ci.com/vyomrastogi/item-service.svg?branch=master)](https://travis-ci.com/vyomrastogi/item-service)|
|sales-order-service| api to add order details to DB using customer-service & item-service for order validation|link| Completed| [![Build Status](https://travis-ci.com/vyomrastogi/sales-order-service.svg?branch=master)](https://travis-ci.com/vyomrastogi/sales-order-service)|
|zipkin-server| zipkin ui to view request traceability|link| Completed| [![Build Status](https://travis-ci.com/vyomrastogi/zuul-server.svg?branch=master)](https://travis-ci.com/vyomrastogi/zuul-server)|
|eureka-server| Eureka discovery server to register service health and available servers|link| Completed| :x: Pending|
|zuul-server| Provides proxy url for routing to all services|link| Completed| :x: Pending|
|config-server|Centralized configuration management for all components|link| Completed| :x: Pending|

---
#### APIs


###### ms-customer-service 
```
1.  http://localhost/api/customer/customer-service
2.  http://localhost/api/customer/customer-service/{emailId}
```

###### ms-item-service 
```
1.  http://localhost/api/item/item-service
2.  http://localhost/api/item/item-service/{item names}
```

###### ms-sales-order-service
``` 
1.  http://localhost:8100/api/sales-order-service/order
    Request Sample : 
	{
	"orderDescription" : "test description",
	"orderDate" : "2018-06-04",
	"customerEmailId": "some.person@email.com",
	"itemNames" : [ "Item1","Item3" ]
	}
	
2.  http://localhost:8100/api/sales-order-service/orderId/1
	Response Sample : 
	{
    "orderId": 1,
    "customerEmailId": "some.person@email.com",
    "orderDescription": "test description",
    "orderDate": "2018-06-04T00:00:00.000+0000",
    "totalPrice": 400,
    "itemNames": [
        "Item1",
        "Item3"
   ]
   }
```


#### Issues Faced

1. Zuul not able to route request to proper host 
2. Feign not able to pick correct server host from registry
3. Trace log not showing up in zipkin ui 
4. Travis CI - Incorrect heroku key encryption 
