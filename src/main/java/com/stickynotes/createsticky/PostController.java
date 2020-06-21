package com.stickynotes.createsticky;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stickynotes.dto.StickyNotesDto;
import com.stickynotes.pojos.StickyNotesPojo;
import com.stickynotes.services.CreateStickyNotesService;
import com.stickynotes.services.UpdateStickyNotesService;

@Controller
public class PostController {

	@Autowired
	CreateStickyNotesService createStickyNotesService;
	
	@RequestMapping(value = "/createSticky", method = RequestMethod.POST,
			headers = "Accept=application/json")
	@ResponseBody
	public ResponseEntity<StickyNotesDto> createSticky(@RequestBody StickyNotesPojo stickyNotes) {

		return new ResponseEntity<StickyNotesDto>(createStickyNotesService.createStickyNotes(stickyNotes)
				,HttpStatus.OK);
	}

	@Autowired
	UpdateStickyNotesService updateStickyNotesService;
	
	@RequestMapping(value = "/updateSticky", method = RequestMethod.POST,
			headers = "Accept=application/json")
	@ResponseBody
	public ResponseEntity<String> updateSticky(@RequestBody StickyNotesPojo stickyNotes) {

		return new ResponseEntity<String>(updateStickyNotesService.updateSticky(stickyNotes)
				,HttpStatus.OK);
	}
}
