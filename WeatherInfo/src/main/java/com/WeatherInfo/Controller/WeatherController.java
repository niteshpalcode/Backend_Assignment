package com.WeatherInfo.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.WeatherInfo.Entity.LocationDetails;
import com.WeatherInfo.Entity.RequestGene;
import com.WeatherInfo.Entity.ResponseGene;
import com.WeatherInfo.Entity.WeatherInformation;
import com.WeatherInfo.Exception.LocationException;
import com.WeatherInfo.Exception.WeatherInfornationException;
import com.WeatherInfo.Service.LocationService;
import com.WeatherInfo.Service.WeatherService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
public class WeatherController {

	
	@Autowired
	private LocationService locationService;

	@Autowired
	private WeatherService weatherService;
	
	@PostMapping("/weatherInfo")
	public ResponseEntity<ResponseGene> getWeatherInfo(@RequestBody RequestGene requestGene)
			throws JsonMappingException, JsonProcessingException, WeatherInfornationException, LocationException {
		
				Optional<LocationDetails> locaOptional = locationService.getLocationEntityFromDB(requestGene.getPincode());

				ResponseGene responseDto = new ResponseGene();

				if (locaOptional.isPresent()) {

					LocationDetails location = locaOptional.get();

					responseDto.setLocation(location);

					Optional<WeatherInformation> weatherInfo = weatherService.getWeatherInfoIfPresent(requestGene);

					if (weatherInfo.isEmpty()) {

						WeatherInformation weatherInfo2 = weatherService.getWeatherInfo(requestGene);

						responseDto.setWeatherInfo(weatherInfo2);

					} else {

						WeatherInformation info = weatherInfo.get();

						responseDto.setWeatherInfo(info);
					}

				} else {

					LocationDetails saveLocationEntity = locationService.getLocationEntity(requestGene.getPincode());

					WeatherInformation weatherInfo3 = weatherService.getWeatherInfo(requestGene);

					responseDto.setLocation(saveLocationEntity);

					responseDto.setWeatherInfo(weatherInfo3);
				}

				return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	
	
	
	
	

}
