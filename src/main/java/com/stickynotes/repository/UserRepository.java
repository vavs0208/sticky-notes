package com.stickynotes.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stickynotes.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User,String> {
	
}
