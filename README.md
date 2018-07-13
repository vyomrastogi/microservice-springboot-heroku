## Microservices - Online Shipping 

Contains of following components 
1. customer-service  [![Build Status](https://travis-ci.com/vyomrastogi/customer-service.svg?branch=master)](https://travis-ci.com/vyomrastogi/customer-service)
2. item-service  [![Build Status](https://travis-ci.com/vyomrastogi/item-service.svg?branch=master)](https://travis-ci.com/vyomrastogi/item-service)
3. sales-order-service  [![Build Status](https://travis-ci.com/vyomrastogi/sales-order-service.svg?branch=master)](https://travis-ci.com/vyomrastogi/sales-order-service)
4. eureka-server --done   
5. config-server --done   <webhook auto refresh is not working, looks like heroku randomly assigns rabbit mq instances>
6. zipkin-server --done - <traces not visible though, check version compitability>
7. zuul-server [![Build Status](https://travis-ci.com/vyomrastogi/zuul-server.svg?branch=master)](https://travis-ci.com/vyomrastogi/zuul-server)

Technology stack to achieve 

![Technology Stack](https://github.com/vyomrastogi/ms-online-shipping/blob/master/technology_diag.png)


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
