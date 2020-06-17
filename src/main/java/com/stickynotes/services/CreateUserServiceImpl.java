package com.stickynotes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stickynotes.dao.CreateUserDao;
import com.stickynotes.dto.UserDto;
import com.stickynotes.pojos.UserPojo;

@Service
public class CreateUserServiceImpl implements CreateUserService{

	@Autowired
	CreateUserDao creatUserDao;
	
	/*
	 * @see com.stickynotes.dao.CreateUserDao #createUser(com.stickynotes.pojos.UserPojo)
	 */
	@Override
	public UserDto createUser(UserPojo userPojo) {
		
		return creatUserDao.createUser(userPojo);
	}

	
}
