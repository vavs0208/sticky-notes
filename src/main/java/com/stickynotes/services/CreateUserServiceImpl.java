package com.stickynotes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stickynotes.dao.CreateUserDao;
import com.stickynotes.dto.SearchUserDto;
import com.stickynotes.pojos.UserPojo;

@Service
public class CreateUserServiceImpl implements CreateUserService{

	@Autowired
	CreateUserDao creatUserDao;
	
	@Override
	public SearchUserDto createUser(UserPojo userPojo) {
		
		return creatUserDao.createUser(userPojo);
	}

	
}