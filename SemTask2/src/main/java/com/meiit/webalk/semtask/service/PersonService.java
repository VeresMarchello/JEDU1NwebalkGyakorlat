package com.meiit.webalk.semtask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meiit.webalk.semtask.model.Person;
import com.meiit.webalk.semtask.repository.PersonRepository;

@Service
public class PersonService
{
	@Autowired
	private PersonRepository personRepository;

	public PersonService(PersonRepository personRepository)
	{
		this.personRepository = personRepository;
	}

	public Person findByUserId(int id) 
	{
		return personRepository.findByUserId(id);
	}
	
	public Person savePerson(Person person) 
	{
		return personRepository.save(person);
	}
}
