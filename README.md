# Customer Management Using Spring boot Hibernate MySQL

Customer Management app lets you to understand CRUD operation along with token authentication using JWT(Json Web Token). It lets you to

  - Add Customer
  - Retrieve Customer by ID

### Prerequesites 
- MySQL
- Maven
- JDK 8
    
### Environment Setup

1) Create a database named **perpule** in MySQL 
2) Give username and password of MySQL in application.properties file which is present in the project folder

Run Application by issuing the command from project root folder
```sh
$ mvn spring-boot:run
```
Open this url in your browser http://localhost:8080

### Rest APIs

X-AUTH-TOKEN header must be added for all the endpoints starting with **/api**

X-AUTH-TOKEN is retrieved using login credentials service **/login** 

You must add username and password as **admin** in the user table in order to get Auth Token

```sh
GET  /login - login credentials
GET  /api/customer - get all customers
POST /api/customer - add a customer
GET  /api/customer/{id} - retrieves customer by ID
```
