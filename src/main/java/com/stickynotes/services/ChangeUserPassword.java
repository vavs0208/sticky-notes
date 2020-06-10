package com.stickynotes.services;

import com.stickynotes.dto.SearchUserDto;
import com.stickynotes.pojos.PasswordResetPojo;

public interface ChangeUserPassword {

	public SearchUserDto changeUserPassword(PasswordResetPojo passwordResetPojo);
}
