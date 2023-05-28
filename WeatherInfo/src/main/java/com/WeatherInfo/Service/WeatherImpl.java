package com.WeatherInfo.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.WeatherInfo.Entity.LocationDetails;
import com.WeatherInfo.Entity.RequestGene;
import com.WeatherInfo.Entity.WeatherInformation;
import com.WeatherInfo.Exception.WeatherInfornationException;
import com.WeatherInfo.Repository.LocationRepository;
import com.WeatherInfo.Repository.WeatherRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class WeatherImpl implements WeatherService {

	@Autowired(required = true)
	private WeatherRepository weatherRepository;

	@Autowired(required = true)
	private LocationRepository locationRepository;

	@Autowired(required = true)
	private RestTemplate restTemplate;

	@Override
	public WeatherInformation getWeatherInfo(RequestGene requestGene)
			throws WeatherInfornationException, JsonProcessingException {
		Optional<LocationDetails> loc = locationRepository.findByPincode(requestGene.getPincode());
		LocationDetails location = loc.get();

		String url = "http://api.worldweatheronline.com/premium/v1/past-weather.ashx" + "?q=" + location.getLatitude()
				+ "," + location.getLongitude() + "&date=" + requestGene.getDate() + "&key=3d39530c9e9b4146a6c71400231904"
				+ "&format=json";

		String json = restTemplate.getForObject(url, String.class);

		ObjectMapper objectMapper = new ObjectMapper();

		JsonNode readTree = objectMapper.readTree(json);
		if (readTree.path("data").path("weather") != null) {
			String datestr = readTree.path("data").path("weather").get(0).path("date").asText();

			String sunrise = readTree.path("data").path("weather").get(0).path("astronomy").get(0).path("sunrise")
					.asText();

			String sunset = readTree.path("data").path("weather").get(0).path("astronomy").get(0).path("sunset")
					.asText();

			String moonrise = readTree.path("data").path("weather").get(0).path("astronomy").get(0).path("moonrise")
					.asText();

			String moonset = readTree.path("data").path("weather").get(0).path("astronomy").get(0).path("moonset")
					.asText();

			int maxTemp = readTree.path("data").path("weather").get(0).path("maxtempC").asInt();

			int minTemp = readTree.path("data").path("weather").get(0).path("mintempC").asInt();

			int avgTemp = readTree.path("data").path("weather").get(0).path("avgtempC").asInt();

			double snow_cm = readTree.path("data").path("weather").get(0).path("totalSnow_cm").asDouble();

			double sunHour = readTree.path("data").path("weather").get(0).path("sunHour").asDouble();

			WeatherInformation weatherInfoObj = new WeatherInformation();

			weatherInfoObj.setDate(LocalDate.parse(datestr));

			weatherInfoObj.setSunrise(sunrise);

			weatherInfoObj.setSunset(sunset);

			weatherInfoObj.setMoonrise(moonrise);

			weatherInfoObj.setMoonset(moonset);

			weatherInfoObj.setMaxTempC(maxTemp);

			weatherInfoObj.setMinTempC(minTemp);

			weatherInfoObj.setAvgTempC(avgTemp);
			
			weatherInfoObj.setTotalSnowCm(snow_cm);

			weatherInfoObj.setSunHour(sunHour);

			weatherInfoObj.setLocation(location);

			return weatherRepository.save(weatherInfoObj);
		
		}

		String errorMessage = readTree.path("data").path("error").get(0).path("msg").asText();

		throw new WeatherInfornationException(errorMessage);
		
	}

	@Override
	public Optional<WeatherInformation> getWeatherInfoIfPresent(RequestGene requestGene)
			throws JsonMappingException, JsonProcessingException, WeatherInfornationException {
		List<WeatherInformation> weatherInfoList = weatherRepository.findByDate(requestGene.getDate());

		if (!weatherInfoList.isEmpty()) {
			
			for (WeatherInformation info : weatherInfoList) {
				
				if (info.getLocation().getPincode().equals(requestGene.getPincode())) {
					
					return Optional.of(info);
					
				}
			}
		}
		
		return Optional.empty();
	}

}
