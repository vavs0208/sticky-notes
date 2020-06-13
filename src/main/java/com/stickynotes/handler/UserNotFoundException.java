package com.stickynotes.handler;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

/*
 * This is a Customized Exception class which handles user not found situation.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/*
	 * This method calls the super method to create new exception message.
	 */
	public UserNotFoundException(String message) 
	{
		super(message);
	}
}
