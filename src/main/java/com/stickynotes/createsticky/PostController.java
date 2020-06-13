package com.stickynotes.createsticky;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stickynotes.dto.ProjectStickyDto;
import com.stickynotes.dto.SearchUserDto;
import com.stickynotes.dto.StickyNotesDto;
import com.stickynotes.pojos.PasswordResetPojo;
import com.stickynotes.pojos.ProjectStickyPojo;
import com.stickynotes.pojos.StickyNotesPojo;
import com.stickynotes.pojos.UserPojo;
import com.stickynotes.services.ChangeUserPassword;
import com.stickynotes.services.CreateProjectStickyService;
import com.stickynotes.services.CreateStickyNotesService;
import com.stickynotes.services.CreateUserService;

/*
 * This class controls all the POST services. 
 */
@Controller
public class PostController {

	@Autowired
	CreateStickyNotesService createStickyNotesService;
	
	@Autowired
	ChangeUserPassword changeUserPassword;
	
	@Autowired
	CreateProjectStickyService createProjectStickyService;
	
	@Autowired
	CreateUserService createUserService;

	/*
	 * This method controls the creation of new sticky notes
	 * @see com.stickynotes.services.CreateProjectStickyService #createStickyNotes(com.stickynotes.pojos.StickyNotesPojo)
	 */
	@RequestMapping(value = "/createSticky", method = RequestMethod.POST,headers = "Accept=application/json")
	@ResponseBody
	public ResponseEntity<StickyNotesDto> createSticky(@RequestBody StickyNotesPojo stickyNotes) {

		return new ResponseEntity<StickyNotesDto>(createStickyNotesService.createStickyNotes(stickyNotes)
				,HttpStatus.OK);
	}
		
	/*
	 * The method is responsible for controlling the creation of new user
	 * @see com.stickynotes.services.CreateUserService #createUser(com.stickynotes.pojos.UserPojo)
	 */
	@RequestMapping(value="/addUser", method=RequestMethod.POST, headers="Accept=application/json")
	@ResponseBody
	public ResponseEntity<SearchUserDto> createUser(@Valid @RequestBody UserPojo userPojo){
		
		return new ResponseEntity<SearchUserDto>(createUserService.createUser(userPojo),HttpStatus.OK);
	}
	
	/*
	 * If any user need to change or reset the login password then this method controls that
	 * @see com.stickynotes.services.ChangeUserPassword #changeUserPassword(com.stickynotes.pojos.PasswordResetPojo)
	 */
	@RequestMapping(value="/resetPassword", method=RequestMethod.POST, headers="Accept=application/json")
	@ResponseBody
	public ResponseEntity<SearchUserDto> changeUserPassword(@Valid @RequestBody PasswordResetPojo passwordResetPojo){
		
		return new ResponseEntity<SearchUserDto>(changeUserPassword.changeUserPassword(passwordResetPojo),HttpStatus.OK);
	}
	
	/*
	 * This method controls the creation of new project details in the system
	 * @see com.stickynotes.services.CreateProjectStickyService #createProjectSticky(com.stickynotes.pojos.ProjectStickyPojo)
	 */
	@RequestMapping(value="/createProjectSticky", method=RequestMethod.POST, headers="Accept=application/json")
	@ResponseBody
	public ResponseEntity<ProjectStickyDto> createProjectSticky(@Valid @RequestBody ProjectStickyPojo projectStickyPojo){
		
		return new ResponseEntity<ProjectStickyDto>(createProjectStickyService.createProjectSticky(projectStickyPojo),HttpStatus.OK);
	}
}
