package com.stickynotes.services;

import com.stickynotes.dto.SearchUserDto;
import com.stickynotes.pojos.UserPojo;

public interface UserLoginAuthentictionService {

	public SearchUserDto getLoginUserDetails(UserPojo userPojo);
}
