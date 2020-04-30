package com.stickynotes.services;

import com.stickynotes.dto.StickyNotesDto;
import com.stickynotes.pojos.StickyNotesPojo;

public interface CreateStickyNotesService {

	public StickyNotesDto createStickyNotes(StickyNotesPojo stickyNotes);
}
