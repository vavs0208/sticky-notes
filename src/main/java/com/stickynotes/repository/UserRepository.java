package com.stickynotes.repository;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stickynotes.entities.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity,String> {
	
	 @Query("SELECT u.password FROM UserEntity u where u.userid = :userid")
	 public String findUserDetails(@Param("userid") String userid);
	 
	 @Transactional
	 @Modifying
	 @Query("UPDATE UserEntity u SET u.password= :password where u.userid = :userid")
	 public int updateUserPassword(@Param("password") String password,@Param("userid") String userid);
}
