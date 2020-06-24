package com.stickynotes.repository;

import java.sql.Timestamp;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stickynotes.entities.StickyNotesEntity;

@Repository
public interface CreateStickyRepository extends CrudRepository<StickyNotesEntity,String> {
	
	@Query("select stickyNotes from StickyNotesEntity stickyNotes where stickyNotes.createdDate >?1")
	public Iterable<StickyNotesEntity> fetchStickyNotesEntity(Timestamp createdAt);
	
	@Query("select stickyNotes from StickyNotesEntity stickyNotes where stickyNotes.createdDate >?1 and stickyNotes.userEntity.userid=?2")
	public Iterable<StickyNotesEntity> fetchStickyNotesEntityUser(Timestamp createdAt, String userId);

}
