package com.WeatherInfo.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.WeatherInfo.Entity.WeatherInformation;

public interface WeatherRepository  extends JpaRepository<WeatherInformation, Integer>{

	List<WeatherInformation> findByDate(LocalDate date);

}
