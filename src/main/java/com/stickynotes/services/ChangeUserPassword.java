package com.stickynotes.services;

import com.stickynotes.dto.SearchUserDto;
import com.stickynotes.pojos.PasswordResetPojo;

public interface ChangeUserPassword {

	/*
	 * @see com.stickynotes.services.ChangeUserPasswordImpl #changeUserPassword(com.stickynotes.pojos.PasswordResetPojo)
	 */
	public SearchUserDto changeUserPassword(PasswordResetPojo passwordResetPojo);
}
