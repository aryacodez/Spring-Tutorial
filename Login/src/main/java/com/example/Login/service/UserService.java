package com.example.Login.service;

import com.example.Login.dto.UserDTO;
import com.example.Login.entity.User;

import java.util.List;

public interface UserService {
    void save(UserDTO userDTO);

    User findUserByEmail(String email);

    List<UserDTO> findAllUsers();
}
