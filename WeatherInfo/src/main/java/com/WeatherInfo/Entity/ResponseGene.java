package com.WeatherInfo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseGene {

	
	private LocationDetails location;
	private WeatherInformation weatherInfo;
}
