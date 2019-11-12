# Mini project II in spring boot with Microservices and Kubernates

This Project Uses Spring Security and JWT Authentication for  users.
Kubernetes to manage containers that manage the services.
Docker Engine to run the containers.
Postman to test the APIs.
Kubernetes Service Discovery to locate the different services.
MySQL for the database.
# Services

This Project has been built with 8 Microservices Services.

•	Account Service
•	Catalog Service
•	Order Service
•	Payment Service
•	Paypal Service
•	Bank Service
•	Credit Card Service
•	Shipping

# Requirements
•	Apache Maven 3.6.2
•	Spring
•	Kubernetes
•	Google Cloud Platform  Cloud Shell.
•	IntelliJ or anyother IDE
•	MySQl installation on Cloud shell

### Steps
Before you login, you will be able to access `http://104.155.188.78/viewProducts` that can be viewed by everyone without an account in the system. This displays the products in the catalog.
This Catalog service querries the stock services for all the availble stock and displays it.


##### 1. Create Account
Use below JSON object or create own JSON object with the same format and parameters.
Open Postman:
**METHOD** : POST
**URL**  `http://104.155.188.78/signup`
**BODY** 
```bash
{
    "email":"project@gmail.com",
    "password":"user",
    "phone":"2090909939",
    "name":"User",
    "address":"Chichago",
    "roles":[2]
}
```
Then Send Request.

##### 2. Login
You will login with email used as username and password as password.
Open Postman:
**METHOD** : POST
**URL**  `http://104.155.188.78/signin`
**BODY** 
```bash
{
    "email":"project@gmail.com",
    "password":"user"
}
```
Then Send Request. The Server will respond with a `Token`

##### 3. Place Order.
Open `POSTMAN` and Use the below JSON object or use any , keeping the format.
**METHOD** : POST
**URL**  `http://104.197.165.71/order/add`
**BODY** 
```bash
{
    "productId":11,
    "productName":"iPhone11",
    "productVendor":"Apple",
    "productCategory":"Electronics",
    "producQuantity":15,
    "productAmount":20000.0
}
```

You will recieve a Message that `Your Product has been addded to the cart, Please proceed to checkout to place your order`

##### 4. Checkout Order.
Open Postman (GET Request) or the Web Browser and go to: http://104.197.165.71/order/checkout

This will query the Payment Service that will send you back the list of al payment options registered with.

Chose from :
•	bank
•	paypal
•	creditcard

Whichever Option you choose, send another request to use that option. 
`http://104.197.165.71/order/PAYMENT- OPTION` ie http://104.197.165.71/order/bank

Request goes to the Payment Service, the payment service will forward the request to the chosen option service to process the transaction.

This will send you back a message from either bank/creditcard/paypal service, confirming whether transaction was successful or not.

##### 5. Ship Order.
Open Postman (GET Request) or the Web Browser and go to: http://104.197.165.71/order/shipping

This will send to the shipping service that will process your order for shipping and a message will be sent back whether shipping was successful or not.

###### NB: In case you find any issues in any of the above steps, Please get in touch with the authors.

## Authors Wagobera Edgar Kedi and Sunena Gwachha
