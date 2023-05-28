# Dynamic_PDF_Generation
## Dynamic PDF Generation using Java Template Engine - Spring Boot Application

This project is a Spring Boot application that provides a RESTful API to generate PDF documents dynamically using a Java Template Engine. It utilizes various technologies and dependencies to simplify the process of PDF generation and enable seamless integration with other systems.

## TechStack

The following technologies and dependencies are used in this project:

* Java
* Spring Boot
* Spring Web
* MySQL
* OpenPDF: Java library for generating PDF documents.
* Lombok
* Swagger UI


## Getting Started
To set up and run the application locally, follow these steps:

## Prerequisites:

* Install Java Development Kit (JDK) on your system.
* Set up MySQL or another compatible database server.
* Install STS/Eclipse or any other Java IDE of your choice.
* Install Postman or a similar API testing tool.

## Clone the Repository:
* Clone the project repository to your local machine.
* *git clone <> *

## Configure the Database:

* Clone repo to local system
* Change DB details (DB_Name,Username,Password) present in application.propert file.
* Run the Sprinngboot app
* Using swagger-ui (http://localhost:8888/swagger-ui/index.html#/)

## Installation & Run 
````
    server.port=8888

    spring.datasource.url=jdbc:mysql://localhost:3306/pdf;
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=put your mysql username
    spring.datasource.password=put your mysql password
    
````

## API Documentation:

* http://localhost:8888/generate/addDetails <br>
 This API used for storing UserData <br>
 In request body it will take UserData Entity with Details list of Seller and Buyer <br>
On successfull response it will provide detailsId 

* http://localhost:8888/generate/{detailsId} <br>
 This API used for storing InvoiceData <br>
 In request body it will take InvoiceData Entity with Item's list <br>
   On successfull response it will provide InvoiceId
   
 * http://localhost:8888/generate//pdf/details/{invoiceId} <br>
  This API used for getting Pdf file for perticular InvoiceId <br>
  On successfull we can Download the file

## SpringBoot App Running
![PDF_Generator_App_Running_Pic](https://github.com/niteshpalcode/Backend_Assignment/assets/101392580/5b7e3724-e5c8-4c0d-be52-79761e306237)

 
## Swagger UI 

* Swagger Home Page
![SwaggerUI_Home_Page](https://github.com/niteshpalcode/Backend_Assignment/assets/101392580/987595c6-91aa-42d0-b605-c2ce2f89f546)

* Swagger PDF Controller
![SwaggerUI_PDF_Controller](https://github.com/niteshpalcode/Backend_Assignment/assets/101392580/671636e1-7abe-428f-936f-0e63434321b7)

* Add Details (User And Seller)
![SavedDetails](https://github.com/niteshpalcode/Backend_Assignment/assets/101392580/fd18cbe4-eac9-474c-8253-2667217f0f01)

* Add Item
![ItemAdded](https://github.com/niteshpalcode/Backend_Assignment/assets/101392580/408325fa-6c31-48a2-a123-7b8612832c03)

* PDF Generation through url 


![PDF](https://github.com/niteshpalcode/Backend_Assignment/assets/101392580/bc26e70f-8b5a-44ca-9886-8ef0b1a4a555)





# ThankYou

