package com.shubhi.booking.dto_mappers;

import com.shubhi.booking.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.shubhi.booking.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

	UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

	UserDTO toUserDTO(User user);

	User toUser(UserDTO userDTO);

}
