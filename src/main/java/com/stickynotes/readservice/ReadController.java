package com.stickynotes.readservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.stickynotes.dto.StickyNotesDto;
import com.stickynotes.dto.UserDto;
import com.stickynotes.entities.StickyNotesEntity;
import com.stickynotes.entities.UserEntity;
import com.stickynotes.pojos.UserPojo;
import com.stickynotes.repository.CreateStickyRepository;
import com.stickynotes.repository.UserRepository;
import com.stickynotes.services.FetchStickyService;
import com.stickynotes.services.UserLoginAuthentictionService;
import com.stickynotes.validation.ExceptionResponse;
import com.stickynotes.validation.UserValidation;

/*
 * This class provides control for all the GET services 
 */
@RestController
@PropertySource(value="content.properties")
public class ReadController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserLoginAuthentictionService userLoginAuthentictionService;
	
	@Autowired
	FetchStickyService fetchStickyService;
	
	@Autowired
	Environment env;
	
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
	
	/*
	 * This method fetch all the sticky details for an user specified period of time.
	 * @see com.stickynotes.services.fetchStickyService#fetchStickyNotes(Integer)
	 */
	@RequestMapping(value = "/fetchStickyNotes/{period}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> fetchStickyNotes(@PathVariable("period") Integer period) {
		List<StickyNotesDto> users = new ArrayList<StickyNotesDto>();
		
		if(period>0){
			fetchStickyService.fetchStickyNotes(period).forEach(users::add);
		}
		else{
			return new ResponseEntity<Object>(new ExceptionResponse(new Date(), env.getProperty("invalidtimeperiod"), false),HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<StickyNotesDto>>(users,HttpStatus.OK);
	}
	
	/*
	 * This method fetch all the sticky details of a specific user for a specified period of time.
	 * @see com.stickynotes.services.fetchStickyService#fetchStickyNotesUser(Integer,String)
	 */
	@RequestMapping(value = "/fetchStickyNotesUser", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> fetchStickyNotesUser( @RequestParam(value="period", required=false) String period, 
	        									   @RequestParam(value="userId", required=false) String userId) {
		List<StickyNotesDto> users = new ArrayList<StickyNotesDto>();
		
		if(Integer.parseInt(period)>0 ){
			if(UserValidation.userIdValidation(userId)){
				fetchStickyService.fetchStickyNotesUser(Integer.parseInt(period),userId).forEach(users::add);
			}
			else{
				return new ResponseEntity<Object>(new ExceptionResponse(new Date(), env.getProperty("userIdvalidation"), false),HttpStatus.BAD_REQUEST);
			}
		}
		else{
			return new ResponseEntity<Object>(new ExceptionResponse(new Date(), env.getProperty("invalidtimeperiod"), false),HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<StickyNotesDto>>(users,HttpStatus.OK);
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
	