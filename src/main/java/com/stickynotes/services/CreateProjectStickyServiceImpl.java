package com.stickynotes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stickynotes.dao.CreateProjectStickyDao;
import com.stickynotes.dto.ProjectStickyDto;
import com.stickynotes.pojos.ProjectStickyPojo;

@Service
public class CreateProjectStickyServiceImpl implements CreateProjectStickyService{

	@Autowired
	CreateProjectStickyDao createProjectStickyDao;
	
	/*
	 * @see com.stickynotes.dao.CreateProjectStickyDao #createProjectSticky(com.stickynotes.pojos.ProjectStickyPojo)
	 */
	@Override
	public ProjectStickyDto createProjectSticky(ProjectStickyPojo projectStickyPojo) {
		
		return createProjectStickyDao.createProjectSticky(projectStickyPojo);
	}

}
