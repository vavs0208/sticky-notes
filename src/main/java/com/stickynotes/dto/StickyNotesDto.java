package com.stickynotes.dto;

import java.util.Date;

public class StickyNotesDto {
	
	private String stickyNotesId;
	private String content;
	private Boolean isActive;
    private Date createdAt;
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
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
}
