package com.meiit.webalk.semtask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meiit.webalk.semtask.model.WeldPoint;

@Repository
public interface WeldPointRepository extends JpaRepository<WeldPoint, Long>
{
}
