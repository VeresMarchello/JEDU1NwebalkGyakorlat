package com.meiit.webalk.semtask.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meiit.webalk.semtask.model.Wing;
import com.meiit.webalk.semtask.repository.WingRepository;

@Service
public class WingService
{
	@Autowired
	private WingRepository wingRepository;

	public WingService(WingRepository wingRepository)
	{
		this.wingRepository = wingRepository;
	}

	public List<Wing> getAllWings(Long id)
	{
		return wingRepository.findByFloorId(id);
	}
	
	public Optional<Wing> findById(Long id)
	{
		return wingRepository.findById(id);
	} 
}
