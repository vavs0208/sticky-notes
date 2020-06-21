package com.stickynotes.readservice;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.stickynotes.dto.UserDto;
import com.stickynotes.entities.UserEntity;
import com.stickynotes.pojos.UserPojo;
import com.stickynotes.repository.UserRepository;
import com.stickynotes.services.UserLoginAuthentictionService;
import com.stickynotes.validation.ExceptionResponse;
import com.stickynotes.validation.UserValidation;

/*
 * This class provides control for all the GET services 
 */
@RestController
public class ReadController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserLoginAuthentictionService userLoginAuthentictionService;
	
	/*
	 * This method checks the health of the application
	 */
	@RequestMapping(value = "/health", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> health() {
			String serverStatus = " All OK";
			return new ResponseEntity<String>(serverStatus,HttpStatus.OK);
	}
	
	/*
	 * This method fetch all the user details
	 * @see com.stickynotes.repository.UserRepository#findAll()
	 */
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	@ResponseBody
	public List<UserEntity> getAllUserNames() {
		List<UserEntity> users = new ArrayList<UserEntity>();
		userRepository.findAll().forEach(users::add);
		return users;
	}
	
	/*
	 * This method controls the authentication of the Login user 
	 * @see com.stickynotes.services.UserLoginAuthentictionService #getLoginUserDetails(com.stickynotes.pojos.UserPojo)
	 */
	@RequestMapping(value = "/getLoginUsers", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> getLoginUserDetails(@RequestBody UserPojo userPojo) {
		
		ExceptionResponse exceptionResponse= UserValidation.LoginUserValidation(userPojo);
		if(!exceptionResponse.getStatus()){
			return new ResponseEntity<Object>(exceptionResponse,HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<UserDto>(userLoginAuthentictionService.getLoginUserDetails(userPojo),HttpStatus.OK);
	}
	
}
	