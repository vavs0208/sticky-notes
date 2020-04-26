package com.stickynotes.readservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stickynotes.entities.User;
import com.stickynotes.repository.UserRepository;

@RestController
public class ReadController {
	
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(value = "/health", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> health() {
			String serverStatus = " All OK";
			return new ResponseEntity<String>(serverStatus,HttpStatus.OK);
		}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	@ResponseBody
	public List<User> getAllUserNames() {
		List<User> users = new ArrayList<User>();
		userRepository.findAll().forEach(users::add);
		return users;
		}
}
	