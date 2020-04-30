package com.stickynotes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stickynotes.entities.StickyNotesEntity;

@Repository
public interface CreateStickyRepository extends CrudRepository<StickyNotesEntity,String> {

}
