package com.meiit.webalk.semtask.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meiit.webalk.semtask.model.Reservation;
import com.meiit.webalk.semtask.repository.ReservationRepository;

@Service
public class ReservationService
{
	@Autowired
	private ReservationRepository reservationRepository;

	public ReservationService(ReservationRepository reservationRepository)
	{
		this.reservationRepository = reservationRepository;
	}

	public Reservation saveReservation(Reservation reservation)
	{		
		return reservationRepository.save(reservation);
	}
	
	public List<Reservation> getAllReservations(int id)
	{
		return reservationRepository.findByPersonId(id);
	}
}