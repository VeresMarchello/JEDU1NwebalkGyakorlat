package com.meiit.webalk.semtask.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meiit.webalk.semtask.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>
{
	List<Room> findByWingId(Long id);
}
