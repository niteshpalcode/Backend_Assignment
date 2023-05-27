package com.FreightFox.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FreightFox.Entity.Items;

public interface ItemsRepository extends JpaRepository<Items, Integer> {

}
