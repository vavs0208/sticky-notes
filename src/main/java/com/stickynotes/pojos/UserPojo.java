package com.stickynotes.pojos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.springframework.context.annotation.PropertySource;

/*
 * This class is being used to transfer the form data related to User from the controller method to dao layer.
 */
@PropertySource(value="content.properties")
public class UserPojo {

	@NotBlank(message="{userIdvalidation}")
	private String userid;
	
	private String name;
	
	@Email(regexp = ".+@.+\\..+")
	private String email;
	
	private String country;
	
	@NotBlank(message="{passwordvalidation}")
	@Size(min=8, max=55)
	private String password;
	
	private boolean isAdmin;
	
	
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
