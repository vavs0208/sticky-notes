package com.stickynotes.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stickynotes.dao.FetchStickyDao;
import com.stickynotes.dto.StickyNotesDto;

@Service
public class FetchStickyServiceImpl implements FetchStickyService{

	@Autowired
	FetchStickyDao fetchStickyDao;
	
	/*
	 * @see com.stickynotes.dao.FetchStickyDao #fetchStickyNotes(Integer)
	 */
	@Override
	public List<StickyNotesDto> fetchStickyNotes(Integer period) {
		
		return fetchStickyDao.fetchStickyNotes(period);
	}

	/*
	 * @see com.stickynotes.dao.FetchStickyDao #fetchStickyNotesUser(Integer,String)
	 */
	@Override
	public List<StickyNotesDto> fetchStickyNotesUser(Integer period, String userId) {
		
		return fetchStickyDao.fetchStickyNotesUser(period,userId);
	}
}
