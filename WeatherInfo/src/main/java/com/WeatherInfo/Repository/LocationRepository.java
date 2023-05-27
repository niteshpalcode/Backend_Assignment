package com.WeatherInfo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.WeatherInfo.Entity.LocationDetails;

public interface LocationRepository extends JpaRepository<LocationDetails, Integer>{

	Optional<LocationDetails> findByPincode(String pincode);

}
