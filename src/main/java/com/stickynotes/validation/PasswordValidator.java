package com.stickynotes.validation;

public class PasswordValidator {
	
	public static Boolean validatePassword(String password){
		   
		if(password.length()<8 || password.length()>55){
			return false;
		}
		
		return true;
	}
}
