# PayFast API Gateway Integration With JAVA (Payfast Sandbox)

Its an API for pay-fast payment gateway integration using JAVA that contains following EndPoints: This is for demo purpose and using payfast sandbox
- /generate
- /redirect 
- /cancel 
- /notify
- /status
- /confirmservice

# Technologies And Tools Used:
* Payfast sandbox
* Java 1.8
* Spring WEB, Spring Boot, Spring Data
* Database H2 (In-Memory DB).
* Maven as a build Tool
* OpenAPI V3 with swaggerUI 

# Description And Run Setup

- On APIs startup, H2 DB will execute *data.sql* scripts for initial data insertion.
  
- For running as mvn project user following command

- mvn clean install test
  
- Swagger UI for API documentation is accessible from : 
http://localhost:8080/certtinpay/swagger-ui.html
  
# Work Flow

/generate api is used for generation a get request to payfast payment gateway and will send back a string url that contains all the required GET query param as of today date. This url will open payfast sandbox page and user can either cancel or complete the payment.Also transaction detail is saved in H2 db for tracking with status NEW.

/cancel will be used as call back url if user click cancel button on payfast sandbox a call back is send to /cancel

/notify api is the main api , when user click on complete payment , payfast sandbox will post back data to this url. this is post request and have @RequestBody param for receiving data from paynment gateway based on payment status H2 database table will be updated. i.e COMPLETED or CANCELLED

/redirect api is always used when payment gateway want to redirect user to merchant site. Please note that no data will be posted to this url from payment gateway.

#Waqas Ahmed
 