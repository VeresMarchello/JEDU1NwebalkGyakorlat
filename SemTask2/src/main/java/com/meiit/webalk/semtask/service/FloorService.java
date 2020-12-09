package com.meiit.webalk.semtask.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meiit.webalk.semtask.model.Floor;
import com.meiit.webalk.semtask.repository.FloorRepository;

@Service
public class FloorService
{
	@Autowired
	private FloorRepository floorRepository;

	public FloorService(FloorRepository floorRepository)
	{
		this.floorRepository = floorRepository;
	}

	public List<Floor> getAllFloors(Long id)
	{
		return floorRepository.findByHotelId(id);
	}
	
	public Optional<Floor> findById(Long id)
	{
		return floorRepository.findById(id);	
	}
}
