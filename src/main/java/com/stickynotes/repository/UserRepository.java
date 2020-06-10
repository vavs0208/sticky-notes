package com.stickynotes.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stickynotes.entities.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity,String> {
	
	 @Query("SELECT u.password FROM UserEntity u where u.userid = :userid")
	 public String findUserDetails(@Param("userid") String userid);
}
