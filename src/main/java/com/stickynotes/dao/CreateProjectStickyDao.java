package com.stickynotes.dao;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import com.stickynotes.dto.ProjectStickyDto;
import com.stickynotes.entities.ProjectStickyEntity;
import com.stickynotes.pojos.ProjectStickyPojo;
import com.stickynotes.repository.CreateProjectRepository;

@Repository
@PropertySource(value="content.properties")
public class CreateProjectStickyDao {

	@Autowired
	CreateProjectRepository createProjectRepository;
	
	@Autowired
	Environment env;
	
	public ProjectStickyDto createProjectSticky(ProjectStickyPojo projectStickyPojo){
		
		ProjectStickyDto projectStickyDto=new ProjectStickyDto();
		ModelMapper modelMapper = new ModelMapper();
		ProjectStickyEntity projectStickyEntity=new ProjectStickyEntity();
		
		projectStickyPojo.setIsActive(true);
		projectStickyPojo.setCreatedDate(new Date());
		projectStickyPojo.setUpdatedDate(new Date());
		modelMapper.map(projectStickyPojo, projectStickyEntity);
		
		ProjectStickyEntity projectStickyEntitySave=createProjectRepository.save(projectStickyEntity);
		modelMapper.map(projectStickyEntitySave, projectStickyDto);
		
		return projectStickyDto;
	}
}
