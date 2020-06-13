package com.stickynotes.services;

import com.stickynotes.dto.SearchUserDto;
import com.stickynotes.pojos.UserPojo;

public interface CreateUserService {

	/*
	 * @see com.stickynotes.services.CreateUserServiceImpl #createUser(com.stickynotes.pojos.UserPojo)
	 */
	public SearchUserDto createUser(UserPojo userPojo);
	
}
