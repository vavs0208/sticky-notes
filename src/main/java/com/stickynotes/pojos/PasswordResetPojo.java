package com.stickynotes.pojos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.context.annotation.PropertySource;

/*
 * This class is being used to transfer the form data of functionality related to User password reset from the controller method to dao layer.
 */
@PropertySource(value="content.properties")
public class PasswordResetPojo {

	@NotBlank(message="{userIdvalidation}")
	private String userid;
	
	@NotBlank(message="{passwordvalidation}")
	@Size(min=8, max=55)
	private String password;
	
	
	@NotBlank(message="{passwordvalidation}")
	@Size(min=8, max=55)
	private String newPassword;
	
	@NotBlank(message="{passwordvalidation}")
	@Size(min=8, max=55)
	private String oldPassword;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	
	
}
