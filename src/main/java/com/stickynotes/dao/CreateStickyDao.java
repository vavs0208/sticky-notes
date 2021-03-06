package com.stickynotes.dao;

import java.util.Date;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stickynotes.dto.StickyNotesDto;
import com.stickynotes.entities.ProjectStickyEntity;
import com.stickynotes.entities.StickyNotesEntity;
import com.stickynotes.entities.UserEntity;
import com.stickynotes.pojos.StickyNotesPojo;
import com.stickynotes.repository.CreateProjectRepository;
import com.stickynotes.repository.CreateStickyRepository;
import com.stickynotes.repository.UserRepository;

/*
 * This class is to create connection with the database and save the required entity.
 */
@Repository
public class CreateStickyDao {
	
	@Autowired
	UserRepository userRepository;

	@Autowired
	CreateStickyRepository createStickyRepository;
	
	@Autowired
	CreateProjectRepository createProjectRepository;

	/*
	 * This method implements the actual logic to create a new Sticky Note.
	 * @see 
	 * Parameter com.stickynotes.pojos.StickyNotesPojo
	 * Return    com.stickynotes.dto.StickyNotesDto
	 */
	public StickyNotesDto createStickyNotes(StickyNotesPojo stickyNotesPojo) {
		
		Optional<UserEntity> optional = userRepository.findById(stickyNotesPojo.userid);
		UserEntity userEntity  = optional.get();
		Optional<ProjectStickyEntity> optionalProject=createProjectRepository.findById(stickyNotesPojo.projectid);
		ProjectStickyEntity projectStickyEntity=optionalProject.get();
		StickyNotesEntity stickyNotesEntity = new StickyNotesEntity();
		stickyNotesEntity.setStickyNotesId(stickyNotesPojo.getStickyNotesId());
		stickyNotesEntity.setUserEntity(userEntity);
		stickyNotesEntity.setCreatedDate(new Date());
		stickyNotesEntity.setUpdatedAt(new Date());
		stickyNotesEntity.setContent(stickyNotesPojo.getContent());
		stickyNotesEntity.setIsActive(true);
		stickyNotesEntity.setProjectStickyEntity(projectStickyEntity);
		
		StickyNotesEntity stickyNotesEntityUpdated = createStickyRepository.save(stickyNotesEntity);
		
		StickyNotesDto stickyNotesDto =  new StickyNotesDto();
		ModelMapper modelMapper = new ModelMapper();
		
		modelMapper.map(stickyNotesEntityUpdated, stickyNotesDto);
		return stickyNotesDto;
	}
}
