package com.stickynotes.pojos;

import java.util.Date;

public class StickyNotesPojo {
	
	public String userid;
	public String content;
	public Boolean isActive;
	public Date createdDate;
	public Date updatedDate;
	public String stickyNotesId;
	
	public String getStickyNotesId() {
		return stickyNotesId;
	}
	public void setStickyNotesId(String stickyNotesId) {
		this.stickyNotesId = stickyNotesId;
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
	
}
