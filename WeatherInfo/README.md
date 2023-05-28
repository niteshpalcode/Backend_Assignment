# Weather Info for Pincode
## Building a Weather Information REST API
This project is designed to offer a REST API that allows users to obtain weather information based on a specific day and pincode. The API utilizes the OpenWeather Geocoding API to retrieve the latitude and longitude associated with the provided pincode. Subsequently, it employs the World Weather API to gather weather data for the corresponding location. By combining these APIs, the project enables users to access accurate weather information by specifying a particular day and pincode.




### Technical Stacks

- Spring Boot 
- Spring Framework
- Spring Data JPA 
- MySQL 
- Hibernate
- Java
- Swagger UI
- Postman
- Spring Security



### Installation & Run
- Before running the API server, you have to update the database configuration inside the application.properties file
- Update the port number, username and password as per your local database configuration
````
    server.port=8888

    spring.datasource.url=jdbc:mysql://localhost:3306/ecomdb;
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=put your mysql username
    spring.datasource.password=put your mysql password
    
````

## API's 
* OpenWeather Geocoding API (https://openweathermap.org/api)
This API used for getting latitude and longitude of given pincode
* World Weather API (https://www.worldweatheronline.com/weather-api)
This API used for getting weather information of that pincode on a perticular date.


## Links

* http://localhost:8185/weatherInfo
Returns the weather information for a particular day and pincode.

### RequestBody Formate
````

{
  "pincode":175103,
  "date":"2023-02-15"
}
````

### ResponseBody Formate

````
{
"location": {
  "locationId": 1,
  "pincode": "201306",
  "latitude": 28.5506,
  "longitude": 77.4375,
  "contry": "IN"
},
"weatherInfo": {
  "weatherId": 2,
  "date": "2023-02-15",
  "sunrise": "06:59 AM",
  "sunset": "06:10 PM",
  "moonrise": "02:17 AM",
  "moonset": "12:40 PM",
  "maxTempC": 29,
  "minTempC": 13,
  "avgTempC": 20,
  "totalSnowCm": 0,
  "sunHour": 11.5
}

````

## Weatheer App Running (SpringBoot)

![WeatherApprunniing](https://github.com/niteshpalcode/Backend_Assignment/assets/101392580/af6b0d01-d2be-425d-ab02-7c5ddfe3372e)


## PostMan UI



* Request Body & response Body

<br>

![WeatherInfo](https://github.com/niteshpalcode/Backend_Assignment/assets/101392580/250904c6-be2c-4ffa-b9a2-6348cb8c5773)












