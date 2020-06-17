package com.stickynotes.validation;

import java.util.Date;
import com.stickynotes.pojos.UserPojo;

public class UserValidation {
	
	public static ExceptionResponse createUserValidation(UserPojo userPojo){
		
		if(userPojo!=null){
			
			if(userPojo.getUserid()==null || userPojo.getUserid()==""){
				return new ExceptionResponse(new Date(),"The userId can not be blank",false);
			}
			
			if(userPojo.getPassword()==null || userPojo.getPassword()==""){
				return new ExceptionResponse(new Date(),"Password can not be blank",false);
			}
			else{
				if(PasswordValidator.validatePassword(userPojo.getPassword())==false){
					return new ExceptionResponse(new Date(),"Password size must be between 8 and 55",false);
				}
			}
			
			if(EmailValidator.validateEmail(userPojo.getEmail())==false){
				return new ExceptionResponse(new Date(),"Email must be well formed",false);
			}
		}
		else{
			return new ExceptionResponse(new Date(),"User details not present",false);
		}
		
		return new ExceptionResponse(new Date(),"",true);
	}
	
	public static ExceptionResponse ChangeUserPasswordValidation(UserPojo userPojo){
		
		if(userPojo!=null){
			
			if(userPojo.getUserid()==null || userPojo.getUserid()==""){
				return new ExceptionResponse(new Date(),"The userId can not be blank",false);
			}
			
			if(userPojo.getPassword()==null || userPojo.getPassword()==""){
				return new ExceptionResponse(new Date(),"Password can not be blank",false);
			}
			else{
				if(PasswordValidator.validatePassword(userPojo.getPassword())==false){
					return new ExceptionResponse(new Date(),"Password size must be between 8 and 55",false);
				}
			}
			
			if(userPojo.getOldPassword()==null || userPojo.getOldPassword()==""){
				return new ExceptionResponse(new Date(),"Password can not be blank",false);
			}
			else{
				if(PasswordValidator.validatePassword(userPojo.getOldPassword())==false){
					return new ExceptionResponse(new Date(),"Password size must be between 8 and 55",false);
				}
			}
			
			if(userPojo.getNewPassword()==null || userPojo.getNewPassword()==""){
				return new ExceptionResponse(new Date(),"Password can not be blank",false);
			}
			else{
				if(PasswordValidator.validatePassword(userPojo.getNewPassword())==false){
					return new ExceptionResponse(new Date(),"Password size must be between 8 and 55",false);
				}
			}
		}
		else{
			return new ExceptionResponse(new Date(),"User details not present",false);
		}
		
		return new ExceptionResponse(new Date(),"",true);
	}
	
	public static ExceptionResponse LoginUserValidation(UserPojo userPojo){
		
		if(userPojo!=null){
			
			if(userPojo.getUserid()==null || userPojo.getUserid()==""){
				return new ExceptionResponse(new Date(),"The userId can not be blank",false);
			}
			
			if(userPojo.getPassword()==null || userPojo.getPassword()==""){
				return new ExceptionResponse(new Date(),"Password can not be blank",false);
			}
			else{
				if(PasswordValidator.validatePassword(userPojo.getPassword())==false){
					return new ExceptionResponse(new Date(),"Password size must be between 8 and 55",false);
				}
			}
		}
		else{
			return new ExceptionResponse(new Date(),"User details not present",false);
		}
		
		return new ExceptionResponse(new Date(),"",true);
	}
}
