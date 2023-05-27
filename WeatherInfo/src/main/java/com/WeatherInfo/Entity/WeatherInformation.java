package com.WeatherInfo.Entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherInformation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer weatherId;
	private LocalDate date;
	private String sunrise;
	private String sunset;
	private Integer maxTempC;
	private Integer minTempC;
	private Integer avgTempC;
	private Double totalSnowCm;
	private Double sunHour;
	private String moonrise;
	private String moonset;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "location_id")
	private LocationDetails location;

}
