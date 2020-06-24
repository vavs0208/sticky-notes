package com.stickynotes.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {
	
	public static final Pattern VALID_EMAIL_PATTERN = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
			
	public static Boolean validateEmail(String email){
		
		Matcher matcher = VALID_EMAIL_PATTERN.matcher(email);
		
		if(!matcher.find()){
			return false;
		}
		
		return true;
	}
}
