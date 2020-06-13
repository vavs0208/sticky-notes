package com.stickynotes.dao;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import com.stickynotes.dto.SearchUserDto;
import com.stickynotes.entities.UserEntity;
import com.stickynotes.handler.UserNotFoundException;
import com.stickynotes.pojos.UserPojo;
import com.stickynotes.readservice.PasswordEncoderMatcher;
import com.stickynotes.repository.UserRepository;

/*
 * This class is to create connection with the database and save the required entity.
 */
@Repository
@PropertySource(value="content.properties")
public class UserLoginAuthenticationDao {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoderMatcher passwordEncoderMatcher;
	
	@Autowired
	Environment env;

	/*
	 * This method implements the actual logic to authenticate a login user details.
	 * @see 
	 * Parameter com.stickynotes.pojos.UserPojo
	 * Return    com.stickynotes.dto.SearchUserDto
	 */
	public SearchUserDto getLoginUserDetails(UserPojo userRecord) {
		
		SearchUserDto searchUserDto= new SearchUserDto();
		Optional<UserEntity> user= userRepository.findById(userRecord.getUserid());
		
		try {
			
			if(user.isPresent()){
				UserEntity userEntity= new UserEntity();
				userEntity=user.get();
				
				ModelMapper modelMapper = new ModelMapper();
				modelMapper.map(userEntity, searchUserDto);
				
				if(passwordEncoderMatcher.match(userRecord.getPassword(), userEntity.getPassword())){
					searchUserDto.setPresent(true);
					searchUserDto.setMessege(env.getProperty("uservalid"));
				}
				else{
					searchUserDto.setPresent(false);
					searchUserDto.setMessege(env.getProperty("usernotvalid"));
				}
			}
			else{
				throw new UserNotFoundException(env.getProperty("usernotfound"));
			}
			
		}catch (UserNotFoundException e) {
			throw new UserNotFoundException(env.getProperty("usernotfound"));
			
		}catch (Exception e) {
			
		}
		
		return searchUserDto;
	}
}
