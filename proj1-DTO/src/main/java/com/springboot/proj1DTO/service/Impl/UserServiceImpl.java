package com.springboot.proj1DTO.service.Impl;

import com.springboot.proj1DTO.entity.User;
import com.springboot.proj1DTO.repository.UserRepository;
import com.springboot.proj1DTO.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        User eusers = userRepository.findById(user.getId()).get();
        eusers.setFirstName(user.getFirstName());
        User updatedUser = userRepository.save(eusers);
        return updatedUser;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
