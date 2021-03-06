package com.stickynotes.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

/*
 * This class is being used as an entity to create new StickyNotes and persist in the database.
 */
@Entity
@Table(name="sticky_notes_vaibhav")
public class StickyNotesEntity {
	
	@Id 
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid",strategy="uuid")
	@ColumnDefault("1001")
	@Column(name="sticky_notes_id")
	private String stickyNotesId;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
	private UserEntity userEntity;
	
	private String content;
	
	@Column(name="is_active")
	private Boolean isActive;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_date", nullable = false)
    @LastModifiedDate
    private Date updatedAt;

    @ManyToOne(optional = false)
    @JoinColumn(name="project_id", nullable=false)
	private ProjectStickyEntity projectStickyEntity;

    
	public ProjectStickyEntity getProjectStickyEntity() {
		return projectStickyEntity;
	}

	public void setProjectStickyEntity(ProjectStickyEntity projectStickyEntity) {
		this.projectStickyEntity = projectStickyEntity;
	}

	public String getStickyNotesId() {
		return stickyNotesId;
	}

	public void setStickyNotesId(String stickyNotesId) {
		this.stickyNotesId = stickyNotesId;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
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

