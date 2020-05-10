package com.stickynotes.services;

import com.stickynotes.dto.SearchUserDto;
import com.stickynotes.pojos.UserPojo;

public interface ChangeUserPassword {

	public SearchUserDto changeUserPassword(UserPojo userPojo);
}
