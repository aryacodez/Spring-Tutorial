package com.springboot.proj1DTO.Mapper;

import com.springboot.proj1DTO.dto.UserDto;
import com.springboot.proj1DTO.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoUserMapper {

    AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);

    //User JPA Entity -> User Dto
    UserDto mapToUserDto(User user);

    //UserDTO -> User JPA Entity
    User mapToUser(UserDto userDto);
}
