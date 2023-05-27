package com.WeatherInfo.Service;

import java.util.Optional;

import com.WeatherInfo.Entity.LocationDetails;
import com.WeatherInfo.Exception.LocationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface LocationService {
	Optional<LocationDetails> getLocationEntityFromDB(String pincode)
			throws JsonMappingException, JsonProcessingException, LocationException;

	LocationDetails getLocationEntity(String pincode)
			throws JsonMappingException, JsonProcessingException, LocationException;

}
