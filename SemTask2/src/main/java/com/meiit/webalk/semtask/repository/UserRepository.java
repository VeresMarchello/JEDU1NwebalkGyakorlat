package com.meiit.webalk.semtask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meiit.webalk.semtask.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
	User findByUserName(String userName);
}