package com.stickynotes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stickynotes.dao.UserLoginAuthenticationDao;
import com.stickynotes.dto.SearchUserDto;
import com.stickynotes.pojos.UserPojo;

@Service
public class UserLoginAuthentictionServiceImpl implements UserLoginAuthentictionService{

	@Autowired
	UserLoginAuthenticationDao userLoginAuthenticationDao;
	
	/*
	 * @see com.stickynotes.dao.UserLoginAuthenticationDao #getLoginUserDetails(com.stickynotes.pojos.UserPojo)
	 */
	@Override
	public SearchUserDto getLoginUserDetails(UserPojo userPojo) {
		
		return userLoginAuthenticationDao.getLoginUserDetails(userPojo);
	}

}
