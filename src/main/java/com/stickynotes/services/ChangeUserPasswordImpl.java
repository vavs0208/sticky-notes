package com.stickynotes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stickynotes.dao.ChangeUserPasswordDao;
import com.stickynotes.dto.SearchUserDto;
import com.stickynotes.pojos.PasswordResetPojo;

@Service
public class ChangeUserPasswordImpl implements ChangeUserPassword{

	@Autowired
	ChangeUserPasswordDao changeUserPasswordDao;
	
	@Override
	public SearchUserDto changeUserPassword(PasswordResetPojo passwordResetPojo) {
		
		return changeUserPasswordDao.changeUserPassword(passwordResetPojo);
	}

}
