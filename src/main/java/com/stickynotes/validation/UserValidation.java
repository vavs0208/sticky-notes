package com.stickynotes.validation;

import java.util.Date;
import com.stickynotes.pojos.UserPojo;

public class UserValidation {
	
	public static Boolean userIdValidation(String userId){
		if(userId==null || userId==""){
			return false;
		}
		return true;
	}
	
	public static Boolean passwordValidation(String password){
		if(password==null || password==""){
			return false;
		}
		return true;
	}
	
	public static ExceptionResponse createUserValidation(UserPojo userPojo){
		
		if(userPojo!=null){
			
			if(!userIdValidation(userPojo.getUserid())){
				return new ExceptionResponse(new Date(),"The userId can not be blank",false);
			}
			
			if(!passwordValidation(userPojo.getPassword())){
				return new ExceptionResponse(new Date(),"Password can not be blank",false);
			}
			else{
				if(!PasswordValidator.validatePassword(userPojo.getPassword())){
					return new ExceptionResponse(new Date(),"Password size must be between 8 and 55",false);
				}
			}
			
			if(!EmailValidator.validateEmail(userPojo.getEmail())){
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
			
			if(!userIdValidation(userPojo.getUserid())){
				return new ExceptionResponse(new Date(),"The userId can not be blank",false);
			}
			
			if(!passwordValidation(userPojo.getPassword())){
				return new ExceptionResponse(new Date(),"Password can not be blank",false);
			}
			else{
				if(!PasswordValidator.validatePassword(userPojo.getPassword())){
					return new ExceptionResponse(new Date(),"Password size must be between 8 and 55",false);
				}
			}
			
			if(!passwordValidation(userPojo.getOldPassword())){
				return new ExceptionResponse(new Date(),"Password can not be blank",false);
			}
			else{
				if(!PasswordValidator.validatePassword(userPojo.getOldPassword())){
					return new ExceptionResponse(new Date(),"Password size must be between 8 and 55",false);
				}
			}
			
			if(!passwordValidation(userPojo.getNewPassword())){
				return new ExceptionResponse(new Date(),"Password can not be blank",false);
			}
			else{
				if(!PasswordValidator.validatePassword(userPojo.getNewPassword())){
					return new ExceptionResponse(new Date(),"Password size must be between 8 and 55",false);
				}
			}
			
			if(!userPojo.getPassword().equals(userPojo.getNewPassword())){
				return new ExceptionResponse(new Date(),"New password does not match",false);
			}
			
		}
		else{
			return new ExceptionResponse(new Date(),"User details not present",false);
		}
		
		return new ExceptionResponse(new Date(),"",true);
	}
	
	public static ExceptionResponse LoginUserValidation(UserPojo userPojo){
		
		if(userPojo!=null){
			
			if(!userIdValidation(userPojo.getUserid())){
				return new ExceptionResponse(new Date(),"The userId can not be blank",false);
			}
			
			if(!passwordValidation(userPojo.getPassword())){
				return new ExceptionResponse(new Date(),"Password can not be blank",false);
			}
			else{
				if(!PasswordValidator.validatePassword(userPojo.getPassword())){
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
