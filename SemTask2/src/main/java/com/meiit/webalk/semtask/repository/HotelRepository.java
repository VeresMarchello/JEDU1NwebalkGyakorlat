package com.meiit.webalk.semtask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meiit.webalk.semtask.model.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long>
{

}
