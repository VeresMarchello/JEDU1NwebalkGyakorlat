package com.meiit.webalk.semtask.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meiit.webalk.semtask.model.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long>
{
	List<Reservation> findByPersonId(int id);  
}