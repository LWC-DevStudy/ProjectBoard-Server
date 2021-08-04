package com.project.board.controller;


import com.project.board.dto.SignupRequestDto;
import com.project.board.dto.UserRequestDto;
import com.project.board.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody UserRequestDto requestDto){
        return userService.login(requestDto);
    }

    @PostMapping("/user/register")
    public void userRegister(@RequestBody SignupRequestDto signupRequestDto){
        userService.registerUser(signupRequestDto);
    }

}
