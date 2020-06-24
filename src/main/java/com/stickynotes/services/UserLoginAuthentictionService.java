package com.stickynotes.services;

import com.stickynotes.dto.UserDto;
import com.stickynotes.pojos.UserPojo;

public interface UserLoginAuthentictionService {

	/*
	 * @see com.stickynotes.services.UserLoginAuthentictionServiceImpl #getLoginUserDetails(com.stickynotes.pojos.UserPojo)
	 */
	public UserDto getLoginUserDetails(UserPojo userPojo);
}
