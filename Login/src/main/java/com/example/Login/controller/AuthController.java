package com.example.Login.controller;

import com.example.Login.dto.UserDTO;
import com.example.Login.entity.User;
import com.example.Login.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AuthController {

    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/index")
    public String home(){
        return "index";
    }
    //handle login request
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    //handle method: Handle User Registration form request
    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        //create model object to store form object

        UserDTO user = new UserDTO();
        model.addAttribute("user",user);
        return "register";
    }

    //handler for user registration
    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDTO userDTO,
                               BindingResult result, Model model){
        User existing = userService.findUserByEmail(userDTO.getEmail());
        if(existing!=null && existing.getEmail()!=null && !existing.getEmail().isEmpty()){
            result.rejectValue("email",null,"Email Already Exists");
        }
        if(result.hasErrors()){
            model.addAttribute("user",userDTO);
            return "/register";
        }
        userService.save(userDTO);
        return "redirect:/register?success";
    }

    @GetMapping("/users")
    //get list of users
    public String users(Model model){
        List<UserDTO> userDTO = userService.findAllUsers();
        model.addAttribute("users",userDTO);
        return "users";
    }
}
