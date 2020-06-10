package com.stickynotes.dao;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import com.stickynotes.dto.SearchUserDto;
import com.stickynotes.entities.UserEntity;
import com.stickynotes.pojos.UserPojo;
import com.stickynotes.readservice.PasswordEncoderMatcher;
import com.stickynotes.repository.UserRepository;


@Repository
@PropertySource(value="content.properties")
public class CreateUserDao {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoderMatcher passwordEncoderMatcher;
	
	@Autowired
	Environment env;
	
	public SearchUserDto createUser(UserPojo userPojo){
		
		SearchUserDto searchUserDto=new SearchUserDto();
		
		UserEntity userEntity=new UserEntity();
		ModelMapper modelMapper = new ModelMapper();
		userPojo.setAdmin(true);
		userPojo.setPassword(passwordEncoderMatcher.hashPassword(userPojo.getPassword()));
		modelMapper.map(userPojo, userEntity);
		
		UserEntity userEntityNew=userRepository.save(userEntity);
		
		modelMapper.map(userEntityNew, searchUserDto);
		
		searchUserDto.setPresent(true);
		searchUserDto.setMessege(env.getProperty("usercreated"));
		
		return searchUserDto;
	}
	
}
