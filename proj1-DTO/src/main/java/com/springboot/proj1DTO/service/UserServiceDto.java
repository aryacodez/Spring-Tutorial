package com.springboot.proj1DTO.service;

import com.springboot.proj1DTO.dto.UserDto;
import com.springboot.proj1DTO.entity.User;

import java.util.List;

public interface UserServiceDto {
    UserDto createUser(UserDto user);

    UserDto getUserById(Long id);

    List<UserDto> getAllUsers();

    UserDto updateUser(UserDto user);

    void deleteUser(Long id);
}
