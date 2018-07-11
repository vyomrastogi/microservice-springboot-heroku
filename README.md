## Microservices - Online Shipping 

Contains of following components 
1. customer-service  -- done
2. item-service  -- done
3. sales-order-service  -- done
4. eureka-server 
5. config-server
6. zipkin-server 

Technology stack to achieve 

![Technology Stack](https://github.com/vyomrastogi/ms-online-shipping/blob/master/technology_diag.png)


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