package com.stickynotes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stickynotes.dao.ChangeUserPasswordDao;
import com.stickynotes.dto.UserDto;
import com.stickynotes.pojos.UserPojo;

@Service
public class ChangeUserPasswordImpl implements ChangeUserPassword{

	@Autowired
	ChangeUserPasswordDao changeUserPasswordDao;
	
	/*
	 * @see com.stickynotes.dao.ChangeUserPasswordDao #changeUserPassword(com.stickynotes.pojos.UserPojo)
	 */
	@Override
	public UserDto changeUserPassword(UserPojo userPojo) {
		
		return changeUserPasswordDao.changeUserPassword(userPojo);
	}

}
