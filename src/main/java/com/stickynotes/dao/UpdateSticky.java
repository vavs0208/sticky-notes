package com.stickynotes.dao;

import java.util.Date;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stickynotes.dto.StickyNotesDto;
import com.stickynotes.entities.StickyNotesEntity;
import com.stickynotes.entities.UserEntity;
import com.stickynotes.pojos.StickyNotesPojo;
import com.stickynotes.repository.CreateStickyRepository;
import com.stickynotes.repository.UserRepository;

@Repository
public class UpdateSticky {
	
	@Autowired
	CreateStickyRepository createStickyRepository;
	@Autowired
	UserRepository userRepository;
	
	
	public StickyNotesDto updateStickyNotes(StickyNotesPojo stickyNotesPojo) {
		Optional<UserEntity> optional = userRepository.findById(stickyNotesPojo.userid);
	UserEntity userEntity  = optional.get();
	StickyNotesEntity stickyNotesEntity=new StickyNotesEntity();
	stickyNotesEntity.setUserEntity(userEntity);	
	
		Optional<StickyNotesEntity> stickyOptional = createStickyRepository.findById(stickyNotesPojo.getStickyNotesId());
		stickyNotesEntity.setStickyNotesId(stickyNotesPojo.getStickyNotesId());
		StickyNotesEntity StickyNotesEntity  = stickyOptional.get();
		stickyNotesEntity.setContent(stickyNotesPojo.content);
		stickyNotesEntity.setCreatedAt(StickyNotesEntity.getCreatedAt());
		stickyNotesEntity.setUpdatedAt(new Date());
		stickyNotesEntity.setIsActive(true);
		
			StickyNotesEntity stickyNotesEntityUpdated = createStickyRepository.save(stickyNotesEntity);
			StickyNotesDto stickyNotesDto =  new StickyNotesDto();
			ModelMapper modelMapper = new ModelMapper();		
			modelMapper.map(stickyNotesEntityUpdated, stickyNotesDto);
			return stickyNotesDto;
	
						
	}

}
