package com.stickynotes.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stickynotes.entities.LabelEntity;

@Repository
public interface LabelRepository extends CrudRepository<LabelEntity,String> { 
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE LabelEntity SET labelName=:labelName WHERE labelId=:labelId")
	int updateLabel(@Param("labelId")String labelId, @Param("labelName")String labelName);

}
