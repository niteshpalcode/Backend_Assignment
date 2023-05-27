package com.WeatherInfo.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class LocationDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer locationId;
	private String pincode;
	private Double latitude;
	private Double longitude;
	private String contry;
	@JsonIgnore
	@OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
	private List<WeatherInformation> weatherInfoList = new ArrayList<>();

}
