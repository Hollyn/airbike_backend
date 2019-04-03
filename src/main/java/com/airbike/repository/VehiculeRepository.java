package com.airbike.repository;

import com.airbike.model.Vehicule;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {
	boolean existsByNumberPlate(String numberPlate);
	Vehicule findById(long id);
    List<Vehicule> findByUserId(Long userId);
}
