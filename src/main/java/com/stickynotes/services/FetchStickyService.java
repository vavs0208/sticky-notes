package com.stickynotes.services;

import java.util.List;
import com.stickynotes.dto.StickyNotesDto;

public interface FetchStickyService {

	/*
	 * @see com.stickynotes.services.FetchStickyServiceImpl #fetchStickyNotes(Integer)
	 */
	public List<StickyNotesDto> fetchStickyNotes(Integer period);
	
	/*
	 * @see com.stickynotes.services.FetchStickyServiceImpl #fetchStickyNotesUser(Integer,String)
	 */
	public List<StickyNotesDto> fetchStickyNotesUser(Integer period, String userId);
}
