package com.springboot.proj1DTO.service;

import com.springboot.proj1DTO.entity.User;
import java.util.*;
public interface UserService {
    User createUser(User user);

    User getUserById(Long id);

    List<User> getAllUsers();

    User updateUser(User user);

    void deleteUser(Long id);
}
