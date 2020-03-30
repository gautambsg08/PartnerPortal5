package com.testgaap.partnerportalnew.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.testgaap.partnerportalnew.app.model.User;

public interface UserRepository extends CrudRepository<User, Integer>{

	User findByUsername(String username);
}
