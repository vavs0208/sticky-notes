package com.stickynotes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stickynotes.dao.ChangeUserPasswordDao;
import com.stickynotes.dto.SearchUserDto;
import com.stickynotes.pojos.UserPojo;

@Service
public class ChangeUserPasswordImpl implements ChangeUserPassword{

	@Autowired
	ChangeUserPasswordDao changeUserPasswordDao;
	
	@Override
	public SearchUserDto changeUserPassword(UserPojo userPojo) {
		
		return changeUserPasswordDao.changeUserPassword(userPojo);
	}

}
