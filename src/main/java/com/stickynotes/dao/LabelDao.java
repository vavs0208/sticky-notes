package com.stickynotes.dao;

import java.util.Date;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stickynotes.dto.LabelDto;
import com.stickynotes.entities.LabelEntity;
import com.stickynotes.entities.UserEntity;
import com.stickynotes.pojos.LabelPojo;
import com.stickynotes.repository.LabelRepository;
import com.stickynotes.repository.UserRepository;

@Repository
public class LabelDao {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	LabelRepository labelRepository;
	
	ModelMapper modelMapper = new ModelMapper();
	
	
	public LabelDto createLabel(LabelPojo labelPojo) {
		Optional<UserEntity> optional = userRepository.findById(labelPojo.getUserid());
		UserEntity userEntity  = optional.get();
		
		LabelEntity labelEntity = new LabelEntity();
		labelEntity.setLabelName(labelPojo.getLabelName());
		labelEntity.setCreatedDate(new Date());
		labelEntity.setUpdatedDate(new Date());
		labelEntity.setIsActive(true);
		labelEntity.setIsUserCreated(true);
		labelEntity.setUserEntity(userEntity);
		
		LabelEntity labelEntityUpdated =  labelRepository.save(labelEntity);
		LabelDto labelDto =  new LabelDto();
		
		modelMapper.map(labelEntityUpdated, labelDto);
		
		return labelDto;
	}
	
	public int updateLabel(LabelPojo labelPojo) {
		
		int response =  labelRepository.updateLabel(labelPojo.labelId, labelPojo.labelName);
		
		return response;
		
	}
}
