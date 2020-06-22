package com.stickynotes.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
//	@Autowired
//	UserRepository userRepository;
//	
	public String updateStickyNotes(StickyNotesPojo stickyNotesPojo) {
					int i = createStickyRepository.updateStickyNotesEntity(stickyNotesPojo.content, stickyNotesPojo.stickyNotesId);
					fetchStickyNotes(stickyNotesPojo);
		if(i!=0) {	
			return "record updated";
		}else {
			return "record not updated";	
	}
	}
	
	//Below code is for fetching notes created in last 6 months
	public List<StickyNotesEntity> fetchStickyNotes(StickyNotesPojo stickyNotesPojo) {
		List<StickyNotesEntity> notes = new ArrayList<StickyNotesEntity>();
		Calendar c = Calendar.getInstance();
		c.add(c.MONTH, -6);
		Date sixMonthOld = c.getTime();
        java.sql.Date sqlDate = new java.sql.Date(sixMonthOld.getTime());
		createStickyRepository.fetchStickyNotesEntity(sqlDate).forEach(notes::add);
		System.out.println("noted: "+notes);
		return notes;
		}
}
