package com.stickynotes.repository;

import javax.transaction.TransactionScoped;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stickynotes.entities.StickyNotesEntity;
import com.stickynotes.entities.UserEntity;


	@Repository
	public interface StickyNotesRepository extends CrudRepository<StickyNotesEntity,Long> {
		
	@TransactionScoped
	@Modifying(clearAutomatically = true) 
	@Query (update stickyNotes from StickyNotesEntity stickyNotes set stickyNotes.content=?1 where stickyNotes.stickyNotesId=?2)
	public int updateStickyNotesEntity(String content, Long  stickyNotesId);
	}
