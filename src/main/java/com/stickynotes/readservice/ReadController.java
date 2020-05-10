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
import com.stickynotes.entities.UserEntity;
import com.stickynotes.pojos.UserPojo;
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
	
}
	