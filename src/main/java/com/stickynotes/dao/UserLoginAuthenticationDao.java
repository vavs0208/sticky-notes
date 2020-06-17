package com.stickynotes.dao;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import com.stickynotes.dto.UserDto;
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
	 * Return    com.stickynotes.dto.userDto
	 */
	public UserDto getLoginUserDetails(UserPojo userRecord) {
		
		UserDto userDto= new UserDto();
		Optional<UserEntity> user= userRepository.findById(userRecord.getUserid());
		
		try {
			
			if(user.isPresent()){
				UserEntity userEntity= new UserEntity();
				userEntity=user.get();
				
				ModelMapper modelMapper = new ModelMapper();
				modelMapper.map(userEntity, userDto);
				
				if(passwordEncoderMatcher.match(userRecord.getPassword(), userEntity.getPassword())){
					userDto.setPresent(true);
					userDto.setMessege(env.getProperty("uservalid"));
				}
				else{
					userDto.setPresent(false);
					userDto.setMessege(env.getProperty("usernotvalid"));
				}
			}
			else{
				throw new UserNotFoundException(env.getProperty("usernotfound"));
			}
			
		}catch (UserNotFoundException e) {
			throw new UserNotFoundException(env.getProperty("usernotfound"));
			
		}catch (Exception e) {
			
		}
		
		return userDto;
	}
}
