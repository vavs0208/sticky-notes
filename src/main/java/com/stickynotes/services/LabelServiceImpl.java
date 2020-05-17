package com.stickynotes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stickynotes.dao.LabelDao;
import com.stickynotes.dto.LabelDto;
import com.stickynotes.pojos.LabelPojo;

@Service
public class LabelServiceImpl implements LabelService{
	
	@Autowired
	LabelDao LabelDao;

	@Override
	public LabelDto createLabel(LabelPojo labelPojo) {
		return LabelDao.createLabel(labelPojo);
	}

	@Override
	public int updateLabel(LabelPojo labelPojo) {
		return LabelDao.updateLabel(labelPojo);
	}
	

}
