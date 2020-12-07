package com.meiit.webalk.semtask.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meiit.webalk.semtask.model.WeldPoint;
import com.meiit.webalk.semtask.repository.WeldPointRepository;

@Service
public class WeldPointService
{
	@Autowired
	private WeldPointRepository weldPointRepository;

	public WeldPointService(WeldPointRepository weldPointRepository)
	{
		this.weldPointRepository = weldPointRepository;
	}

	public List<WeldPoint> getAllWeldPoints()
	{
		return weldPointRepository.findAll();
	}

	public void saveWeldPoint(WeldPoint weldPoint)
	{
		weldPointRepository.save(weldPoint);
	}
	
	public void deleteWeldPointById(Long id)
	{
		weldPointRepository.deleteById(id);
	}

	public Optional<WeldPoint> findById(Long id)
	{
		return weldPointRepository.findById(id);
	}

}
