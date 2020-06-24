package com.stickynotes.services;

import com.stickynotes.dto.UserDto;
import com.stickynotes.pojos.UserPojo;

public interface CreateUserService {

	/*
	 * @see com.stickynotes.services.CreateUserServiceImpl #createUser(com.stickynotes.pojos.UserPojo)
	 */
	public UserDto createUser(UserPojo userPojo);
	
}
