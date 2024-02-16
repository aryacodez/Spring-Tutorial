package com.springboot.proj1DTO.service.Impl;

import com.springboot.proj1DTO.Mapper.AutoUserMapper;
import com.springboot.proj1DTO.Mapper.UserMapper;
import com.springboot.proj1DTO.dto.UserDto;
import com.springboot.proj1DTO.entity.User;
import com.springboot.proj1DTO.exception.EmailAlreadyExistsException;
import com.springboot.proj1DTO.exception.ResourceNotFoundException;
import com.springboot.proj1DTO.repository.UserRepository;
import com.springboot.proj1DTO.service.UserService;
import com.springboot.proj1DTO.service.UserServiceDto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceDtoImpl implements UserServiceDto {

    private UserRepository userRepository;
    private ModelMapper modelMapper;
    @Override
    public UserDto createUser(UserDto userDto) {
        //convert userDto into User JPA entity
//        User user1 = UserMapper.mapToUser(userDto);
//        User user1 = modelMapper.map(userDto,User.class);

        Optional<User> optUser =  userRepository.findByEmail(userDto.getEmail());
        if(optUser.isPresent()){
            throw new EmailAlreadyExistsException("Email Already exists for the user");
        }
        User user1 = AutoUserMapper.MAPPER.mapToUser(userDto);
        User savedUser = userRepository.save(user1);

        //convert user jpa entity to userDto
//        UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);
//        UserDto savedUserDto = modelMapper.map(savedUser,UserDto.class);
        UserDto savedUserDto = AutoUserMapper.MAPPER.mapToUserDto(savedUser);


        return savedUserDto;
    }


    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("User","id",id)
        );
//        User user2 = user.get();
//        return UserMapper.mapToUserDto(user2);
//        return modelMapper.map(user2,UserDto.class);
        return AutoUserMapper.MAPPER.mapToUserDto(user);


    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
//        return users.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
//        return users.stream().map((user)->modelMapper.map(user,UserDto.class)).collect(Collectors.toList());
        return users.stream().map((user)->AutoUserMapper.MAPPER.mapToUserDto(user)).collect(Collectors.toList());

    }

    @Override
    public UserDto updateUser(UserDto user) {
//        User eusers = userRepository.findById(user.getId()).get();
        User eusers = userRepository.findById(user.getId()).orElseThrow(
                ()->new ResourceNotFoundException("User","id",user.getId())
        );

        eusers.setFirstName(user.getFirstName());
        User updatedUser = userRepository.save(eusers);
//        return UserMapper.mapToUserDto(updatedUser);
//        return modelMapper.map(updatedUser,UserDto.class);
        return AutoUserMapper.MAPPER.mapToUserDto(updatedUser);

    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("User","id",id)
        );
        userRepository.deleteById(id);
    }
}
