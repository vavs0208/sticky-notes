package com.stickynotes.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.stickynotes.dto.StickyNotesDto;
import com.stickynotes.entities.StickyNotesEntity;
import com.stickynotes.repository.CreateStickyRepository;

@Repository
public class FetchStickyDao {

	@Autowired
	CreateStickyRepository createStickyRepository;
	
	/*
	 * This method fetch all the sticky details for a user specified period of time.
	 * @see 
	 * Parameter Integer
	 * Return    com.stickynotes.dto.StickyNotesDto
	 */
	public List<StickyNotesDto> fetchStickyNotes(Integer period) {
		
		List<StickyNotesEntity> notes = new ArrayList<StickyNotesEntity>();
		List<StickyNotesDto> notesDto = new ArrayList<StickyNotesDto>();
		Calendar c = Calendar.getInstance();
		c.add(c.MONTH, -period);
		Date sixMonthOld = c.getTime();
        java.sql.Timestamp sqlDate = new java.sql.Timestamp(sixMonthOld.getTime());
        
		createStickyRepository.fetchStickyNotesEntity(sqlDate).forEach(notes::add);
		
		ModelMapper modelMapper = new ModelMapper();
		
		for(StickyNotesEntity sEntity: notes){
			StickyNotesDto sDto = new StickyNotesDto();
			modelMapper.map(sEntity, sDto);
			notesDto.add(sDto);
		}
		
		return notesDto;
	}
	
	/*
	 * This method fetch all the sticky details of a specific user for a specified period of time.
	 * @see 
	 * Parameter Integer,String
	 * Return    com.stickynotes.dto.StickyNotesDto
	 */
	public List<StickyNotesDto> fetchStickyNotesUser(Integer period,String userId) {
		
		List<StickyNotesEntity> notes = new ArrayList<StickyNotesEntity>();
		List<StickyNotesDto> notesDto = new ArrayList<StickyNotesDto>();
		Calendar c = Calendar.getInstance();
		c.add(c.MONTH, -period);
		Date sixMonthOld = c.getTime();
        java.sql.Timestamp date = new java.sql.Timestamp(sixMonthOld.getTime());
        
		createStickyRepository.fetchStickyNotesEntityUser(date,userId).forEach(notes::add);
		
		ModelMapper modelMapper = new ModelMapper();
		
		for(StickyNotesEntity sEntity: notes){
			StickyNotesDto sDto = new StickyNotesDto();
			modelMapper.map(sEntity, sDto);
			notesDto.add(sDto);
		}
		
		return notesDto;
	}
}
