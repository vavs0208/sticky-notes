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

@Repository
@PropertySource(value="content.properties")
public class ChangeUserPasswordDao {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoderMatcher passwordEncoderMatcher;
	
	@Autowired
	Environment env;

	public SearchUserDto changeUserPassword(UserPojo userPojo){
		SearchUserDto searchUserDto=new SearchUserDto();
		String newPassword=userPojo.getPassword();
		
		Optional<UserEntity> user= userRepository.findById(userPojo.getUserid());
		
		try {
			if(user.isPresent()){
				UserEntity userEntity= user.get();
				ModelMapper modelMapper= new ModelMapper();
				modelMapper.map(userEntity, userPojo);
				
				if(passwordEncoderMatcher.match(newPassword, userPojo.getPassword())){
					modelMapper.map(userPojo, searchUserDto);
					searchUserDto.setPresent(true);
					searchUserDto.setMessege(env.getProperty("samepassword"));
					return searchUserDto;
				}
				
				userPojo.setPassword(passwordEncoderMatcher.hashPassword(newPassword));
				modelMapper.map(userPojo, userEntity);
				
				UserEntity userEntityNew=userRepository.save(userEntity);
				modelMapper.map(userEntityNew, searchUserDto);
				
				searchUserDto.setPresent(true);
				searchUserDto.setMessege(env.getProperty("changepassword"));
			}
			else{
				throw new UserNotFoundException(env.getProperty("usernotfound"));
			}
			
		}catch (UserNotFoundException e) {
			throw new UserNotFoundException(env.getProperty("usernotfound"));
			
		}catch (Exception e) {
			return null;
		}
		
		return searchUserDto;
	}
}
