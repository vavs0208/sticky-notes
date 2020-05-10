package com.stickynotes.readservice;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class PasswordEncoderMatcher {

	public boolean match(String passText,String passEncoded){
		boolean result;
		if(BCrypt.checkpw(passText, passEncoded)){
			result=true;
		}
		else{
			result=false;
		}
		return result;
	}
	
	public String hashPassword(String plainTextPassword){
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	}
}
