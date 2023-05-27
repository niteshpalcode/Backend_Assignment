package com.FreightFox.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FreightFox.Entity.Details;

public interface DetailsRepository extends JpaRepository<Details, Integer> {

}
