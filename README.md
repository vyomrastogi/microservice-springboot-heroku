## Case Study - Microservices

The repository contains various project built to do a case study on "How to make microservices with Spring Boot? " 

-----------------------------------------------------------------------------------


#### Technology Diagram

![Technology Stack](https://github.com/vyomrastogi/ms-online-shipping/blob/master/technology_diag.png)


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


### Microservices

This collection is monorepo of individual services above mentioned. The key concepts attempted to be shown here are few principles of microservices
 - Autonomous - each service is self contained
 - Business Domain Driven
 - Resilience - Ribbon/Eureka/Zuul to provide high availablity
 - Observable - Logging and tracing
 - Automation - Continuous Deployment with Travis CI. 

```
ms-customer-service 
API :  
1.  https://localhost/api/customer/customers
2.  https://localhost/api/customer/customers/{emailId}
```

```
ms-item-service 
API :  
1.  https://localhost/api/item/items
2.  https://localhost/api/item/items/{item names}
```

```
ms-sales-order-service 
API :  
1.  http://localhost:8100/api/salesorder/order
    Request Sample : 
	{
	"orderDescription" : "test description",
	"orderDate" : "2018-06-04",
	"customerEmailId": "some.person@email.com",
	"itemNames" : [ "Item1","Item3" ]
	}
	
2.  http://localhost:8100/api/salesorder/orderId/1
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
