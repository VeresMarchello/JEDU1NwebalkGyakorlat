package com.meiit.webalk.semtask.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meiit.webalk.semtask.model.Room;
import com.meiit.webalk.semtask.repository.RoomRepository;

@Service
public class RoomService
{
	@Autowired
	private RoomRepository roomRepository;

	public RoomService(RoomRepository roomRepository)
	{
		this.roomRepository = roomRepository;
	}

	public List<Room> getAllRooms(Long id)
	{
		return roomRepository.findByWingId(id);
	}
	
	public Optional<Room> findByRoomId(Long id) 
	{
		return roomRepository.findById(id);
	}
}
