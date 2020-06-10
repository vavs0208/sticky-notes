package com.stickynotes.readservice;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stickynotes.dto.SearchUserDto;
import com.stickynotes.entities.ProjectStickyEntity;
import com.stickynotes.entities.StickyNotesEntity;
import com.stickynotes.entities.UserEntity;
import com.stickynotes.pojos.UserPojo;
import com.stickynotes.repository.CreateProjectRepository;
import com.stickynotes.repository.CreateStickyRepository;
import com.stickynotes.repository.UserRepository;
import com.stickynotes.services.UserLoginAuthentictionService;

@RestController
public class ReadController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserLoginAuthentictionService userLoginAuthentictionService;
	
	@RequestMapping(value = "/health", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> health() {
			String serverStatus = " All OK";
			return new ResponseEntity<String>(serverStatus,HttpStatus.OK);
		}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	@ResponseBody
	public List<UserEntity> getAllUserNames() {
		List<UserEntity> users = new ArrayList<UserEntity>();
		userRepository.findAll().forEach(users::add);
		return users;
		}
	
	@RequestMapping(value = "/getLoginUsers", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<SearchUserDto> getLoginUserDetails(@Valid @RequestBody UserPojo userRecord) {
		
		return new ResponseEntity<SearchUserDto>(userLoginAuthentictionService.getLoginUserDetails(userRecord),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
	@ResponseBody
	public String deleteUser() {
		
		userRepository.deleteAll();
		return "Done";
	}
	
	@Autowired
	CreateProjectRepository createProjectRepository;
	
	@RequestMapping(value = "/deleteProject", method = RequestMethod.GET)
	@ResponseBody
	public String deleteProject() {
		
		createProjectRepository.deleteAll();
		return "Done";
	}
	
	
	@RequestMapping(value = "/getProject", method = RequestMethod.GET)
	@ResponseBody
	public List<ProjectStickyEntity> getProject() {
		List<ProjectStickyEntity> proj = new ArrayList<ProjectStickyEntity>();
		createProjectRepository.findAll().forEach(proj::add);
		return proj;
	}
	
	@Autowired
	CreateStickyRepository createStickyRepository;
	
	@RequestMapping(value = "/getStickyt", method = RequestMethod.GET)
	@ResponseBody
	public List<StickyNotesEntity> getSticky() {
		List<StickyNotesEntity> sticky = new ArrayList<StickyNotesEntity>();
		createStickyRepository.findAll().forEach(sticky::add);
		return sticky;
	}
}
	