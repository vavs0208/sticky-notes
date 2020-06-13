package com.stickynotes.services;

import com.stickynotes.dto.SearchUserDto;
import com.stickynotes.pojos.UserPojo;

public interface UserLoginAuthentictionService {

	/*
	 * @see com.stickynotes.services.UserLoginAuthentictionServiceImpl #getLoginUserDetails(com.stickynotes.pojos.UserPojo)
	 */
	public SearchUserDto getLoginUserDetails(UserPojo userPojo);
}
