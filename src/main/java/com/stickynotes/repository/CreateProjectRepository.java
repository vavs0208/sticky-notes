package com.stickynotes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stickynotes.entities.ProjectStickyEntity;

@Repository
public interface CreateProjectRepository extends CrudRepository<ProjectStickyEntity,String> {

}
