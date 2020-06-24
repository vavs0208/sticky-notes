package com.stickynotes.services;

import com.stickynotes.dto.UserDto;
import com.stickynotes.pojos.UserPojo;

public interface ChangeUserPassword {

	/*
	 * @see com.stickynotes.services.ChangeUserPasswordImpl #changeUserPassword(com.stickynotes.pojos.UserPojo)
	 */
	public UserDto changeUserPassword(UserPojo userPojo);
}
