package com.meiit.webalk.semtask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meiit.webalk.semtask.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>
{
	Person findByUserId(int id);
}