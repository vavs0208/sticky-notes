package com.stickynotes.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stickynotes.entities.StickyNotesEntity;
import com.stickynotes.entities.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity,String> {
	
}
