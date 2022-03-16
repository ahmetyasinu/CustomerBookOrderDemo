# DemoGetir

Getir Application

Customer Controller
• Will persist new customers
• Will query all orders of the customer ( Paging sounds really nice )
• Book Controller
• Will persist new book
• Will update book’s stock
• Order Controller
• Will persist new order (statuses may used)
• Will update stock records.
(Hint: what if it happens if 2 or more users tries to buy one last book
at the same time)
• Will query order by Id
• List orders by date interval ( startDate - endDate )
• Statistics Controller
• Will serve customer’s monthly order statistics
• Total Order count
• Total amount of all purchased orders
• Total count of purchased books
That endpoint will supply data for the following ui component

we will only consider:

Registering New Customer
• Placing a new order
• Tracking the stock of books
• List all orders of the customer
• Viewing the order details
• Query Monthly Statistics

In order to run this application, Docker should be build with 'docker-compose build' and then run with 'docker-compose up' commands. 
(In case of any errors maven clean install can be executed)

Before starting to try the end points, token should be generated and added as a Header in the Postman requests. 
Postman requests are prepared and placed in 'resources' folder (https://github.com/ahmetyasinu/DemoGetir/blob/master/getir.postman_collection.json).

Technologies
-Java 11

-SpringBoot

-Mysql

-Maven

-Docker

• Logging - Log all changes on entities. SLF4J
• Orika Mapper
• Rest Api
• Jpa
• Beraer Token JWT
• Swagger Ui
• Validate


Authentication
POST: localhost:8080/login

JSON:

{ "username": "", "password": "" }

Response:

{ "token": "beraer" }

Swagger
http://localhost:8080/swagger-ui.html

https://github.com/ahmetyasinu/DemoGetir/blob/master/postmanandswaggerpictures/swagger.png

APIs
All add query results returned an Object. For the get end-points these Object's ids can be used.

1-Customer

-Persist new customers

POST: localhost:8080/customer/add


GET: 	localhost:8080/customer/list

2-Book

-Persist new book

POST: http://localhost:8080/book/add

-Update book’s stock

PUT: "http://localhost:8080/book/update/{id}

3-Order
-Persist new order

POST: http://localhost:8080/order/save

-Query order by id

4-Statistics

-Serve customer’s monthly order statistics

GET: http://localhost:8080/order/betweendates/{startdate}/{enddate}

Many unlisted end points.

