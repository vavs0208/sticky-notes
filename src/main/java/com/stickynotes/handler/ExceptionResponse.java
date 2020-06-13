package com.stickynotes.handler;

import java.util.Date;

/*
 * This class defines the format of the Exception message.
 */
public class ExceptionResponse {

	private Date timestamp;
	private String message;
	private String details;
	
	public ExceptionResponse(Date timestamp, String message, String details) 
	{
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}
	public Date getTimestamp() 
	{
		return timestamp;
	}
	public String getMessage() 
	{
		return message;
	}
	public String getDetails()
	{
		return details;
	}
}
