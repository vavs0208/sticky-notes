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

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
	@Entity
	@Table(name="label_vaibhav")
	public class LabelEntity {
		
		@Id @GeneratedValue(generator="system-uuid")
		@GenericGenerator(name="system-uuid", strategy = "uuid")
		private String labelId;
		
		@ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "user_id", nullable = false)
	    @OnDelete(action = OnDeleteAction.CASCADE)
	    @JsonIgnore
		private UserEntity userEntity;
		
		@Column(name = "label_name",nullable = false)
		private String labelName;
		
		@Column(name = "is_active",nullable = false)
		private Boolean isActive;
		
		@Column(name = "is_user_created",nullable = false)
		private Boolean isUserCreated;
		
		@Temporal(TemporalType.TIMESTAMP)
	    @Column(name = "created_date", nullable = false, updatable = false)
	    @CreatedDate
	    private Date createdDate;

	    @Temporal(TemporalType.TIMESTAMP)
	    @Column(name = "updated_date", nullable = false)
	    @LastModifiedDate
	    private Date updatedDate;

		public String getLabelId() {
			return labelId;
		}

		public void setLabelId(String labelId) {
			this.labelId = labelId;
		}

		public UserEntity getUserEntity() {
			return userEntity;
		}

		public void setUserEntity(UserEntity userEntity) {
			this.userEntity = userEntity;
		}

		public String getLabelName() {
			return labelName;
		}

		public void setLabelName(String labelName) {
			this.labelName = labelName;
		}

		public Boolean getIsActive() {
			return isActive;
		}

		public void setIsActive(Boolean isActive) {
			this.isActive = isActive;
		}

		public Boolean getIsUserCreated() {
			return isUserCreated;
		}

		public void setIsUserCreated(Boolean isUserCreated) {
			this.isUserCreated = isUserCreated;
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
