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
public class ChangeUserPasswordDao {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoderMatcher passwordEncoderMatcher;
	
	@Autowired
	Environment env;

	/*
	 * This method implements the actual logic to change the login user password.
	 * @see 
	 * Parameter com.stickynotes.pojos.UserPojo
	 * Return    com.stickynotes.dto.UserPojo
	 */
	public UserDto changeUserPassword(UserPojo userPojo){
		UserDto userDto=new UserDto();
		ModelMapper modelMapper=new ModelMapper();
		modelMapper.map(userPojo, userDto);
		
		try {
			if(userPojo.getPassword().equals(userPojo.getNewPassword())){
				//String password=userRepository.findUserDetails(passwordResetPojo.getUserid());
				Optional<UserEntity> optional=userRepository.findById(userPojo.getUserid());
				
				if(optional.isPresent()){
					UserEntity userEntity= optional.get();
					String password=userEntity.getPassword();
					if(passwordEncoderMatcher.match(userPojo.getOldPassword(), password)){
					
						if(passwordEncoderMatcher.match(userPojo.getPassword(), password)){
							userDto.setPresent(true);
							userDto.setMessege(env.getProperty("samepassword"));
							return userDto;
						}
						
						userEntity.setPassword(passwordEncoderMatcher.hashPassword(userPojo.getPassword()));
						//modelMapper.map(userPojo, userEntity);
						
						UserEntity userEntityNew=userRepository.save(userEntity);
						modelMapper.map(userEntityNew, userDto);
						
						userDto.setPresent(true);
						userDto.setMessege(env.getProperty("changepassword"));
					}
					else{
						userDto.setPresent(true);
						userDto.setMessege(env.getProperty("notsameoldpassword"));
					}
				}
				else{
					throw new UserNotFoundException(env.getProperty("usernotfound"));
				}
			}
			else{
				userDto.setPresent(true);
				userDto.setMessege(env.getProperty("notsamenewpassword"));
			}
			
		}catch (UserNotFoundException e) {
			throw new UserNotFoundException(env.getProperty("usernotfound"));
			
		}catch (Exception e) {
			return null;
		}
		
		return userDto;
	}
}
