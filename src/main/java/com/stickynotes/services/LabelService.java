package com.stickynotes.services;

import com.stickynotes.dto.LabelDto;
import com.stickynotes.pojos.LabelPojo;

public interface LabelService {
	
	public LabelDto createLabel(LabelPojo labelPojo);
	
	public int updateLabel(LabelPojo labelPojo);

}
