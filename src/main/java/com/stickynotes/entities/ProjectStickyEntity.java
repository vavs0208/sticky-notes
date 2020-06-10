package com.stickynotes.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sticky_project")
public class ProjectStickyEntity {

	@Id
	@Column(name="project_id",nullable=false)
	private String projectID;
	
	@Column(name="user_id",nullable=false)
	private String userId;
	
	@Column(name="project_name",nullable=false)
	private String projectName;
	
	@Column(name="is_active",nullable=false)
	private boolean isActive;
	
	@Column(name="created_date",nullable=false)
	private Date   createdDate;
	
	@Column(name="updated_date",nullable=false)
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
