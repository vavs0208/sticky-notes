package com.stickynotes.services;

import com.stickynotes.dto.UserDto;
import com.stickynotes.pojos.UserPojo;


public interface CreateUserService {

	public UserDto createUser(UserPojo userPojo);
	
}
