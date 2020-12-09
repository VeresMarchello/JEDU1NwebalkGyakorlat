package com.meiit.webalk.semtask.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meiit.webalk.semtask.model.Floor;

@Repository
public interface FloorRepository extends JpaRepository<Floor, Long>
{
	List<Floor> findByHotelId(Long id);
}
