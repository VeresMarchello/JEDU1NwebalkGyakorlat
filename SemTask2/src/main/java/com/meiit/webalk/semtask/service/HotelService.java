package com.meiit.webalk.semtask.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meiit.webalk.semtask.model.Hotel;
import com.meiit.webalk.semtask.repository.HotelRepository;

@Service
public class HotelService
{
	@Autowired
	private HotelRepository hotelRepository;

	public HotelService(HotelRepository hotelRepository)
	{
		this.hotelRepository = hotelRepository;
	}

	public List<Hotel> getAllHotels()
	{
		return hotelRepository.findAll();
	}

	public Optional<Hotel> findById(Long id)
	{
		return hotelRepository.findById(id);
	}
}
