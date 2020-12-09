package com.meiit.webalk.semtask.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meiit.webalk.semtask.model.Wing;

@Repository
public interface WingRepository extends JpaRepository<Wing, Long>
{
	List<Wing> findByFloorId(Long Id);
}
