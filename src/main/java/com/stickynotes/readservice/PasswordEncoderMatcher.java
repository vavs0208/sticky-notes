package com.stickynotes.readservice;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

/*
 * This class is required to Encrypt and Decrypt the password.
 */
@Service
public class PasswordEncoderMatcher {

	/*
	 * This method matches the Decrypted password against the user provided password.
	 */
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
	
	/*
	 * This method Encrypts the user provided password into a hash code.
	 */
	public String hashPassword(String plainTextPassword){
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	}
}
