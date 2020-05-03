package com.stickynotes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stickynotes.dao.CreateStickyDao;
import com.stickynotes.dto.StickyNotesDto;
import com.stickynotes.pojos.StickyNotesPojo;

@Service
public class CreateStickyNotesServiceImpl implements CreateStickyNotesService {

	@Autowired
	CreateStickyDao createStickyDao;
	
	@Override
	public StickyNotesDto createStickyNotes(StickyNotesPojo stickyNotes) {
		return createStickyDao.createStickyNotes(stickyNotes);
	}

	
	
		

}
