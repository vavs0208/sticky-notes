package com.stickynotes.dao;

import java.util.Date;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stickynotes.dto.StickyNotesDto;
import com.stickynotes.entities.StickyNotesEntity;
import com.stickynotes.entities.UserEntity;
import com.stickynotes.pojos.StickyNotesPojo;
import com.stickynotes.repository.CreateStickyRepository;
import com.stickynotes.repository.UserRepository;

@Repository
public class CreateStickyDao {
	
	@Autowired
	UserRepository userRepository;

	@Autowired
	CreateStickyRepository createStickyRepository;
	

	public StickyNotesDto createStickyNotes(StickyNotesPojo stickyNotesPojo) {
		
		Optional<UserEntity> optional = userRepository.findById(stickyNotesPojo.userid);
		UserEntity userEntity  = optional.get();
		StickyNotesEntity stickyNotesEntity = new StickyNotesEntity();
		stickyNotesEntity.setUserEntity(userEntity);
		stickyNotesEntity.setCreatedAt(new Date());
		stickyNotesEntity.setUpdatedAt(new Date());
		stickyNotesEntity.setContent(stickyNotesPojo.getContent());
		stickyNotesEntity.setIsActive(true);
		
		StickyNotesEntity stickyNotesEntityUpdated = createStickyRepository.save(stickyNotesEntity);
		
		StickyNotesDto stickyNotesDto =  new StickyNotesDto();
		ModelMapper modelMapper = new ModelMapper();
		
		modelMapper.map(stickyNotesEntityUpdated, stickyNotesDto);
		return stickyNotesDto;
	}


	public StickyNotesDto updateStickyNotes(StickyNotesPojo stickyNotes) {
		
		
		return null;
	}
}
