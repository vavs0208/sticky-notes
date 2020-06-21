package com.stickynotes.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
public class UpdateStickyDao {
	
	@Autowired
	CreateStickyRepository createStickyRepository;
	@Autowired
	UserRepository userRepository;
	
	public StickyNotesDto updateStickyNotes(StickyNotesPojo stickyNotesPojo) {
		Optional<UserEntity> optional = userRepository.findById(stickyNotesPojo.userid);
		StickyNotesDto stickyNotesDto =  new StickyNotesDto();
	if(optional.isPresent()) {
		UserEntity userEntity  = optional.get();
		StickyNotesEntity stickyNotesEntity=new StickyNotesEntity();
		stickyNotesEntity.setUserEntity(userEntity);	

		Optional<StickyNotesEntity> stickyOptional = createStickyRepository.findByUserEntityAndStickyNotesId(userEntity,stickyNotesPojo.stickyNotesId);
		if(stickyOptional.isPresent()) {
			StickyNotesEntity StickyNotesEntity= stickyOptional.get();
			stickyNotesEntity.setStickyNotesId(stickyNotesPojo.stickyNotesId);
				stickyNotesEntity.setContent(stickyNotesPojo.content);
				stickyNotesEntity.setCreatedAt(StickyNotesEntity.getCreatedAt());
				stickyNotesEntity.setUpdatedAt(new Date());
				stickyNotesEntity.setIsActive(true);		
				int i = createStickyRepository.updateStickyNotesEntity(stickyNotesPojo.content, stickyNotesPojo.stickyNotesId, userEntity);
//					StickyNotesEntity stickyNotesEntityUpdated = createStickyRepository.save(stickyNotesEntity);					
//					ModelMapper modelMapper = new ModelMapper();		
//					modelMapper.map(stickyNotesEntityUpdated, stickyNotesDto);
				stickyNotesDto.setContent(""+i);
			
		}else {
			stickyNotesDto.setContent("No note found to update, of stickyNotesId: "+stickyNotesPojo.stickyNotesId+" and user: "+stickyNotesPojo.userid);}
	
	}else {
		stickyNotesDto.setContent("No user exist of userid: "+stickyNotesPojo.userid);		
	}
	return stickyNotesDto;						
	}

}
