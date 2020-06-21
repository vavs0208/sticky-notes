package com.stickynotes.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stickynotes.entities.StickyNotesEntity;
import com.stickynotes.entities.UserEntity;

@Repository
public interface CreateStickyRepository extends CrudRepository<StickyNotesEntity,String> {

@Query("select stickyNotes from StickyNotesEntity stickyNotes where stickyNotes.userEntity=?1 and stickyNotes.sticky_notes_id=?2")
public Optional<StickyNotesEntity> findByUserEntityAndStickyNotesId(UserEntity userEntity, String stickyNotesId);

@Transactional
@Query("update StickyNotesEntity stickyNotes set stickyNotes.content=?1 where stickyNotes.sticky_notes_id=?2")
@Modifying	
public int updateStickyNotesEntity(String content, String stickyNotesId);

//@Transactional
//@Query("update StickyNotesEntity stickyNotes set stickyNotes.content=?1 where stickyNotes.sticky_notes_id=?2 and stickyNotes.userEntity=?3")
//@Modifying
//
//public int updateStickyNotesEntity(String content, String stickyNotesId, UserEntity userEntitys);

}
