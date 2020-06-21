package com.stickynotes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stickynotes.dao.UpdateStickyDao;
//import com.stickynotes.dao.UpdateSticky;
import com.stickynotes.dto.StickyNotesDto;
import com.stickynotes.pojos.StickyNotesPojo;

@Service
public class UpdateStickyNotesServiceImpl implements UpdateStickyNotesService{
	@Autowired
	UpdateStickyDao updateStickydao;

	@Override
	public String updateSticky(StickyNotesPojo stickyNotesPojo) {
		return updateStickydao.updateStickyNotes(stickyNotesPojo);
	}

}
