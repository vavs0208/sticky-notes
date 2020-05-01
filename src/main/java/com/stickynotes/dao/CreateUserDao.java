package com.stickynotes.dao;


import org.mindrot.jbcrypt.BCrypt;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.stickynotes.dto.UserDto;
import com.stickynotes.entities.UserEntity;
import com.stickynotes.pojos.UserPojo;
import com.stickynotes.repository.UserRepository;


@Repository
public class CreateUserDao {

	@Autowired
	UserRepository userRepository;
	
	
	
	public UserDto createUser(UserPojo userPojo){
		
		UserDto userDto=new UserDto();
		
		UserEntity userEntity=new UserEntity();
		userEntity.setUserid(userPojo.getUserid());
		userEntity.setName(userPojo.getName());
		userEntity.setEmail(userPojo.getEmail());
		userEntity.setCountry(userPojo.getCountry());
		userEntity.setPassword(hashPassword(userPojo.getPassword()));
		
		UserEntity userEntityNew=userRepository.save(userEntity);
		ModelMapper modelMapper = new ModelMapper();
		
		modelMapper.map(userEntityNew, userDto);
		
		return userDto;
	}
	
	public String hashPassword(String plainTextPassword){
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	}
}
