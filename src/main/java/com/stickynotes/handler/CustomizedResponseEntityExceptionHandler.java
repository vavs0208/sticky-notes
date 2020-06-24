package com.stickynotes.handler;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.stickynotes.validation.ExceptionResponse;

/*
 * This class is being used to handled all types of Exception.
 */
@ControllerAdvice  
@RestController 
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	/*
	 * This parent method is for all types of Exception handling.
	 */
	@ExceptionHandler(Exception.class)  
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request)  
	{  
	 
		ExceptionResponse exceptionResponse= new ExceptionResponse(new Date(), ex.getMessage(), false);  
		
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);  
	}  
	
	/*
	 * This method is used to handle Exception if wrong user information provided..
	 */
	@ExceptionHandler(UserNotFoundException.class)  
	public final ResponseEntity<Object> handleUserNotFoundExceptions(UserNotFoundException ex, WebRequest request)  
	{  
	  
		ExceptionResponse exceptionResponse= new ExceptionResponse(new Date(), ex.getMessage(), false);  
		  
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);  
	}  
	
	/*
	 * This method is being used to handled all types of Argument validation Exception.
	 */
	@Override  
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request)   
	{  
		ExceptionResponse exceptionResponse= new ExceptionResponse(new Date(), ex.getBindingResult().toString(), false);  
		   
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);  
	} 
}
