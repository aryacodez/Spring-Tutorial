package com.springboot.proj1DTO.controller;

import com.springboot.proj1DTO.dto.UserDto;
import com.springboot.proj1DTO.entity.User;
import com.springboot.proj1DTO.exception.ErrorDetails;
import com.springboot.proj1DTO.exception.ResourceNotFoundException;
import com.springboot.proj1DTO.service.UserService;
import com.springboot.proj1DTO.service.UserServiceDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/user")
public class UserControllerRefactor {

    private UserServiceDto userService;

    @PostMapping(path = "/create")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user){
        UserDto savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/fetch/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long id){
        UserDto fetchUser = userService.getUserById(id);
        return new ResponseEntity<>(fetchUser,HttpStatus.OK);
    }

    @GetMapping("/fetch-all")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> users = userService.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long id,@RequestBody @Valid UserDto user){
        user.setId(id);
        UserDto updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>("User successfully deleted",HttpStatus.OK);
    }



}
