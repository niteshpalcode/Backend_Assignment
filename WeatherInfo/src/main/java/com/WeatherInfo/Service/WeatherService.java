package com.WeatherInfo.Service;

import java.util.Optional;

import com.WeatherInfo.Entity.RequestGene;
import com.WeatherInfo.Entity.WeatherInformation;
import com.WeatherInfo.Exception.WeatherInfornationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface WeatherService {
	WeatherInformation getWeatherInfo(RequestGene requestGene) throws JsonMappingException,JsonProcessingException , WeatherInfornationException;

	Optional<WeatherInformation> getWeatherInfoIfPresent(RequestGene requestGene)
			throws JsonMappingException, JsonProcessingException, WeatherInfornationException;

}
