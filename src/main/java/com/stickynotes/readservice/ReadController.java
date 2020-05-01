package com.stickynotes.readservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.modelmapper.ModelMapper;
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
	public List<UserEntity> getAllUserNames() {
		List<UserEntity> users = new ArrayList<UserEntity>();
		userRepository.findAll().forEach(users::add);
		return users;
		}
	
	@RequestMapping(value = "/getLoginUsers", method = RequestMethod.POST)
	@ResponseBody
	public SearchUserDto getLoginUserDetails(@RequestBody UserPojo userRecord) {
		
		SearchUserDto searchUserDto= new SearchUserDto();
		Optional<UserEntity> user= userRepository.findById(userRecord.getUserid());
		try {
			
			if(user.isPresent()){
				UserEntity userEntity= new UserEntity();
				userEntity=user.get();
				
				ModelMapper modelMapper = new ModelMapper();
				modelMapper.map(userEntity, searchUserDto);
				
				if(match(userRecord.getPassword(), userEntity.getPassword())){
					searchUserDto.setPresent(true);
					searchUserDto.setMessege("User Authenticated");
				}
				else{
					searchUserDto.setPresent(false);
					searchUserDto.setMessege("User not Authenticated");
				}
			}
			
		} catch (Exception e) {
			searchUserDto.setPresent(user.isPresent());
			searchUserDto.setMessege("User login is unsuccessful");
		}
		
		return searchUserDto;
	}
	
	public boolean match(String passText,String passEncoded){
		boolean result;
		if(BCrypt.checkpw(passText, passEncoded)){
			result=true;
		}
		else{
			result=false;
		}
		return result;
	}
	
}
	