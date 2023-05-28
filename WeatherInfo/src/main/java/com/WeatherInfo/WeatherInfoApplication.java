package com.WeatherInfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class WeatherInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherInfoApplication.class, args);
		System.out.println("Weather app is running...");
	}
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
