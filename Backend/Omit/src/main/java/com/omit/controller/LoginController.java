package com.omit.controller;

import com.omit.domain.user.UserRepository;
import com.omit.dto.LoginRequestDto;
import com.omit.dto.LoginResponseDto;
import com.omit.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class LoginController {
    private final UserRepository userRepository;
    private final LoginService loginService;

    @PostMapping(value = "/auth/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto requestDto) throws Exception{
        return new ResponseEntity<>(loginService.login(requestDto), HttpStatus.OK);
    }

    @PostMapping(value = "/auth/register")
    public ResponseEntity<Boolean> register(@RequestBody LoginRequestDto requestDto) throws Exception{
        return new ResponseEntity<>(loginService.register(requestDto), HttpStatus.OK);
    }

    @GetMapping("/auth/user")
    public ResponseEntity<LoginResponseDto> getUser(@RequestParam String userid) throws Exception{
        return new ResponseEntity<>(loginService.getUsers(userid),HttpStatus.OK);
    }

    @GetMapping("/auth/admin")
    public ResponseEntity<LoginResponseDto> getAdmin(@RequestParam String userid) throws Exception{
        return new ResponseEntity<>(loginService.getUsers(userid),HttpStatus.OK);
    }
}
