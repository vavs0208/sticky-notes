package com.stickynotes.pojos;

import java.util.Date;

public class StickyNotesPojo {
	
	public String stickyNotesId;
	public String userid;
	public String content;
	public Boolean isActive;
	public Date createdAt;
	public Date updatedAt;
	public String projectid;
	
	
	public String getStickyNotesId() {
		return stickyNotesId;
	}
	public void setStickyNotesId(String stickyNotesId) {
		this.stickyNotesId = stickyNotesId;
	}
	public String getProjectid() {
		return projectid;
	}
	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public Date getCreatedDate() {
		return createdAt;
	}
	public void setCreatedDate(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedDate() {
		return updatedAt;
	}
	public void setUpdatedDate(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}
