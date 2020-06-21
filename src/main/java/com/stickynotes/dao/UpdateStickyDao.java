package com.stickynotes.dao;

import java.text.SimpleDateFormat;
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
	//need to create proper layering
	public List<StickyNotesEntity> fetchStickyNotes(StickyNotesPojo stickyNotesPojo) {
		List<StickyNotesEntity> notes = new ArrayList<StickyNotesEntity>();
		Date now = new Date();
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String mysqlDateString = formatter.format(now);
        System.out.println("Java's Default Date Format: " + now);
        System.out.println("Mysql's Default Date Format: " + mysqlDateString);

        java.sql.Date sqlDate = new java.sql.Date(now.getTime());
		createStickyRepository.fetchStickyNotesEntity(sqlDate).forEach(notes::add);
		System.out.println("noted: "+notes);
		return notes;
		}
}
