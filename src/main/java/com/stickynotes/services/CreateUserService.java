package com.stickynotes.services;

import com.stickynotes.dto.SearchUserDto;
import com.stickynotes.pojos.UserPojo;


public interface CreateUserService {

	public SearchUserDto createUser(UserPojo userPojo);
	
}