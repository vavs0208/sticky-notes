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
import com.stickynotes.pojos.PasswordResetPojo;
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
	 * Parameter com.stickynotes.pojos.PasswordResetPojo
	 * Return    com.stickynotes.dto.SearchUserDto
	 */
	public SearchUserDto changeUserPassword(PasswordResetPojo passwordResetPojo){
		SearchUserDto searchUserDto=new SearchUserDto();
		ModelMapper modelMapper=new ModelMapper();
		modelMapper.map(passwordResetPojo, searchUserDto);
		
		try {
			if(passwordResetPojo.getPassword().equals(passwordResetPojo.getNewPassword())){
				//String password=userRepository.findUserDetails(passwordResetPojo.getUserid());
				Optional<UserEntity> optional=userRepository.findById(passwordResetPojo.getUserid());
				
				if(optional.isPresent()){
					UserEntity userEntity= optional.get();
					String password=userEntity.getPassword();
					if(passwordEncoderMatcher.match(passwordResetPojo.getOldPassword(), password)){
					
						if(passwordEncoderMatcher.match(passwordResetPojo.getPassword(), password)){
							searchUserDto.setPresent(true);
							searchUserDto.setMessege(env.getProperty("samepassword"));
							return searchUserDto;
						}
						
						passwordResetPojo.setPassword(passwordEncoderMatcher.hashPassword(passwordResetPojo.getPassword()));
						modelMapper.map(passwordResetPojo, userEntity);
						
						UserEntity userEntityNew=userRepository.save(userEntity);
						modelMapper.map(userEntityNew, searchUserDto);
						
						searchUserDto.setPresent(true);
						searchUserDto.setMessege(env.getProperty("changepassword"));
					}
					else{
						searchUserDto.setPresent(true);
						searchUserDto.setMessege(env.getProperty("notsameoldpassword"));
					}
				}
				else{
					throw new UserNotFoundException(env.getProperty("usernotfound"));
				}
			}
			else{
				searchUserDto.setPresent(true);
				searchUserDto.setMessege(env.getProperty("notsamenewpassword"));
			}
			
		}catch (UserNotFoundException e) {
			throw new UserNotFoundException(env.getProperty("usernotfound"));
			
		}catch (Exception e) {
			return null;
		}
		
		return searchUserDto;
	}
}
