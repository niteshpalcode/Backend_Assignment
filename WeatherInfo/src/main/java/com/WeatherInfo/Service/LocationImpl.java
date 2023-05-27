package com.WeatherInfo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.WeatherInfo.Entity.LocationDetails;
import com.WeatherInfo.Exception.LocationException;
import com.WeatherInfo.Repository.LocationRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class LocationImpl implements  LocationService{

	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private LocationRepository locationRepository;

	@Override
	public Optional<LocationDetails> getLocationEntityFromDB(String pincode)
			throws JsonMappingException, JsonProcessingException, LocationException {
		return locationRepository.findByPincode(pincode);
	}

	@Override
	public LocationDetails getLocationEntity(String pincode)
			throws JsonMappingException, JsonProcessingException, LocationException {
		
				String url = "http://api.openweathermap.org/geo/1.0/zip?zip="+pincode+",in&appid=a46268e8e1b2993a4bde28d893d2c744";
				
				
				
				String json = restTemplate.getForObject(url, String.class);
				
				
				
				ObjectMapper objectMapper = new ObjectMapper();
				
			
				JsonNode readTree = objectMapper.readTree(json);
				
				
				int statusCode = readTree.path("cod").asInt();
				
				
				if(statusCode == 0) {
					
					
					double latitide = readTree.path("lat").asDouble();
					
					
					double longitude = readTree.path("lon").asDouble();
					
					
					String country = readTree.path("country").asText();
					
					
					LocationDetails locationObj = new LocationDetails();
					
					
					locationObj.setPincode(pincode);
					locationObj.setContry(country);
					locationObj.setLatitude(latitide);
					locationObj.setLongitude(longitude);
					
				
					return locationRepository.save(locationObj);
				}
				
				throw new LocationException("Server Error..!");
	}
	
}
