package com.stickynotes.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stickynotes.entities.StickyNotesEntity;
import com.stickynotes.entities.UserEntity;

@Repository
public interface CreateStickyRepository extends CrudRepository<StickyNotesEntity,Long> {

	@Query("select stickyNotes from StickyNotesEntity stickyNotes where stickyNotes.userEntity=?1 and stickyNotes.stickyNotesId=?2")
	public Optional<StickyNotesEntity> findByUserEntityAndStickyNotesId(UserEntity userEntity, Long stickyNotesId);

	
//	@Query("select stickyNotes from StickyNotesEntity stickyNotes where stickyNotes.userEntity=?1")
//	public Optional<StickyNotesEntity> findByUserEntity(UserEntity userEntity);
}
