package com.stickynotes.services;

import com.stickynotes.dto.ProjectStickyDto;
import com.stickynotes.pojos.ProjectStickyPojo;

public interface CreateProjectStickyService {

	/*
	 * @see com.stickynotes.services.CreateProjectStickyServiceImpl #createProjectSticky(com.stickynotes.pojos.ProjectStickyPojo)
	 */
	public ProjectStickyDto createProjectSticky(ProjectStickyPojo projectStickyPojo);
}
