package com.springboot.proj1DTO.Mapper;

import com.springboot.proj1DTO.dto.UserDto;
import com.springboot.proj1DTO.entity.User;

public class UserMapper {


    //Convert User JPA Entity to User Dto
    public static UserDto mapToUserDto(User user){
        UserDto userDto = new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
        return  userDto;
    }

    //Convert User Dto to User JPA Entity
    public static User mapToUser(UserDto userDto){
        User user = new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail()
        );
        return user;
    }
}
