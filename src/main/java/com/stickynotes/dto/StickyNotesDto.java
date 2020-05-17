package com.stickynotes.dto;

import java.util.Date;

public class StickyNotesDto {
	
	private String stickyNotesId;
	private String content;
	private Boolean isActive;
    private Date createdDate;
    private Date updatedDate;
    
    
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
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
}
