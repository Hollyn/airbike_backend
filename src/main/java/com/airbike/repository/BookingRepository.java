package com.airbike.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.airbike.model.Booking;


public interface BookingRepository extends JpaRepository<Booking, Long> {
	Booking findById(long id);
    List<Booking> findByUserId(Long userId);
    List<Booking> findByVehiculeId(Long vehiculeId);
}
