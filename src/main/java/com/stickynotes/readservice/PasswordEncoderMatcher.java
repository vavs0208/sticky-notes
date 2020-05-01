package com.stickynotes.readservice;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordEncoderMatcher {

	public String match(String passText,String passEncoded){
		String result;
		if(passEncoded.equals(hashPassword(passText))){
			result="User Authenticated";
		}
		else{
			result="User not Authenticated";
		}
		return result;
	}
	
	public String hashPassword(String plainTextPassword){
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	}
}
