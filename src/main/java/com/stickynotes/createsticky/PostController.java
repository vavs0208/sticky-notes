package com.stickynotes.createsticky;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stickynotes.dto.LabelDto;
import com.stickynotes.dto.StickyNotesDto;
import com.stickynotes.pojos.LabelPojo;
import com.stickynotes.pojos.StickyNotesPojo;
import com.stickynotes.services.CreateStickyNotesService;
import com.stickynotes.services.LabelService;

@Controller
public class PostController {

	@Autowired
	CreateStickyNotesService createStickyNotesService;
	
	@Autowired
	LabelService labelService;

	@RequestMapping(value = "/createSticky", method = RequestMethod.POST,
			headers = "Accept=application/json")
	@ResponseBody
	public ResponseEntity<StickyNotesDto> createSticky(@RequestBody StickyNotesPojo stickyNotes) {

		return new ResponseEntity<StickyNotesDto>(createStickyNotesService.createStickyNotes(stickyNotes)
				,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/createLabel", method = RequestMethod.POST,
			headers = "Accept=application/json")
	@ResponseBody
	public ResponseEntity<LabelDto> createLabel(@RequestBody LabelPojo labelPojo) {
		return new ResponseEntity<LabelDto>(labelService.createLabel(labelPojo)
				,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/updateLabel", method = RequestMethod.POST,
			headers = "Accept=application/json")
	@ResponseBody
	public ResponseEntity<String> updateLabel(@RequestBody LabelPojo labelPojo) {
		if(labelPojo.getLabelId() !=null) {
			if(labelService.updateLabel(labelPojo) == 1 ) {
				return new ResponseEntity<String>("Updated"
						,HttpStatus.OK);
			}
			else {
				return new ResponseEntity<String>("No Records found"
						,HttpStatus.NOT_FOUND);
			}
		}
		else {
			return new ResponseEntity<String>("No Label Id provided"
					,HttpStatus.NOT_ACCEPTABLE);
		}
	}
}
