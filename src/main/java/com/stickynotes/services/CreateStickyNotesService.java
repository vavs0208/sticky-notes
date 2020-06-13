package com.stickynotes.services;

import com.stickynotes.dto.StickyNotesDto;
import com.stickynotes.pojos.StickyNotesPojo;

public interface CreateStickyNotesService {

	/*
	 * @see com.stickynotes.services.CreateStickyNotesServiceImpl #createStickyNotes(com.stickynotes.pojos.StickyNotesPojo)
	 */
	public StickyNotesDto createStickyNotes(StickyNotesPojo stickyNotes);
}
