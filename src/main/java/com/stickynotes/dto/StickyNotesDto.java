package com.stickynotes.dto;

import java.util.Date;

/*
 * This class is being used to transfer the results of certain functionality related to 'StickyNotes' module to the controller 
 * method from dao layer.
 */
public class StickyNotesDto {
	
	private String stickyNotesId;
	private String content;
	private Boolean isActive;
    private Date createdDate;
    private Date updatedAt;
    
    
	public String getStickyNotesId() {
		return stickyNotesId;
	}
	public void setStickyNotesId(String stickyNotesId) {
		this.stickyNotesId = stickyNotesId;
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
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
}
