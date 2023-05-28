package com.Dynamic_Pdf.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Dynamic_Pdf.Entity.Items;

public interface ItemsRepository extends JpaRepository<Items, Integer> {

}
