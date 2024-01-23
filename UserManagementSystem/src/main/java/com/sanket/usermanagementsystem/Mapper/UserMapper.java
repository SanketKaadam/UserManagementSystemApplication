package com.sanket.usermanagementsystem.Mapper;

import org.mapstruct.Mapper; 
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.sanket.usermanagementsystem.dto.UserDTO;
import com.sanket.usermanagementsystem.entity.User;

@Mapper
public interface UserMapper {
	
	 UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	 
	 @Mapping(target = "UId", ignore = true)
	 User userDtoToUser(UserDTO dto);
	 
	 UserDTO userToUserDTO(User user);
	 
	 
	 
	 @Mapping(target = "UId", ignore = true)
	 @Mapping(target = "name", ignore = true)
	 User userDtoToUserForUpdate(UserDTO dto);
	 
	 

}
