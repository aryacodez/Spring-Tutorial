package com.example.Login.service.Impl;

import com.example.Login.dto.UserDTO;
import com.example.Login.entity.Role;
import com.example.Login.entity.User;
import com.example.Login.repository.RoleRepository;
import com.example.Login.repository.UserRepository;
import com.example.Login.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void save(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getFirstname()+" "+userDTO.getLastname());
        user.setEmail(userDTO.getEmail());
        //ecnrypt password using spring security
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        Role role = roleRepository.findByName("ROLE_ADMIN");
        if(role==null){
            role = checkRoleExists();
        }
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);

    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserDTO> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map((user)->mapToUserDTO(user))
                .collect(Collectors.toList());
    }

    private UserDTO mapToUserDTO(User user){
        UserDTO userDTO = new UserDTO();
        String[] str = user.getName().split(" ");
        userDTO.setFirstname(str[0]);
        userDTO.setLastname(str[1]);
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }

    private Role checkRoleExists(){
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }
}
