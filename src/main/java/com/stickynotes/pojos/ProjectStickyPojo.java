package com.stickynotes.pojos;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import org.springframework.context.annotation.PropertySource;

/*
 * This class is being used to transfer the form data related to Project from the controller method to dao layer.
 */
@PropertySource(value="content.properties")
public class ProjectStickyPojo {

	@NotBlank(message="{projectidvalidation}")
	private String projectID;
	
	@NotBlank(message="{userIdvalidation}")
	private String userId;
	
	@NotBlank(message="{projectnamevalidation}")
	private String projectName;
	
	private boolean isActive;
	private Date   createdDate;
	private Date   updatedDate;
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getProjectID() {
		return projectID;
	}
	public void setProjectID(String projectID) {
		this.projectID = projectID;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	
	
}
