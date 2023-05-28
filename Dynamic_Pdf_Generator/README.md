# Dynamic_PDF_Generation
## Dynamic PDF Generation using Java Template Engine - Spring Boot Application

This project is a Spring Boot application that provides a RESTful API to generate PDF documents dynamically using a Java Template Engine. It utilizes various technologies and dependencies to simplify the process of PDF generation and enable seamless integration with other systems.

## Technologies & Dependencies Used

The following technologies and dependencies are used in this project:

* Java: Programming language used for the application development.
* Spring Boot: Framework used to create the Spring-based application.
* STS/Eclipse: Integrated Development Environment (IDE) for Java development.
* Spring Web: Module for building RESTful web services with Spring.
* Spring Data JPA: Framework for simplifying database access and management.
* MySQL: Relational Database Management System (RDBMS) used for data persistence.
* Spring DevTools: Set of tools for development-time enhancements and automatic application restarts.
* OpenPDF: Java library for generating PDF documents.
* Lombok: Library for reducing boilerplate code in Java classes.
* Postman: API development and testing tool for interacting with the RESTful API endpoints.
* Swagger UI: Framework for generating interactive API documentation.


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
 










