package com.stickynotes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stickynotes.dao.UpdateSticky;
//import com.stickynotes.dao.UpdateSticky;
import com.stickynotes.dto.StickyNotesDto;
import com.stickynotes.pojos.StickyNotesPojo;

@Service
public class UpdateStickyServiceImpl implements UpdateStickyService{
	@Autowired
	UpdateSticky updateStickydao;

	@Override
	public StickyNotesDto updateStickyrags(StickyNotesPojo stickyNotesPojo) {
		return updateStickydao.updateStickyNotes(stickyNotesPojo);
	}

}
