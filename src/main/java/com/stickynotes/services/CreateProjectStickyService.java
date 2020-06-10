package com.stickynotes.services;

import com.stickynotes.dto.ProjectStickyDto;
import com.stickynotes.pojos.ProjectStickyPojo;

public interface CreateProjectStickyService {

	public ProjectStickyDto createProjectSticky(ProjectStickyPojo projectStickyPojo);
}
