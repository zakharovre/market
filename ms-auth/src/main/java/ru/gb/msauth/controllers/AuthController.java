package ru.gb.msauth.controllers;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.market.mscore.configurations.jwt.JwtProvider;
import ru.gb.msauth.models.dtos.AuthRequestDto;
import ru.gb.msauth.models.dtos.AuthResponseDto;
import ru.gb.msauth.models.dtos.SignUpRequestDto;
import ru.gb.msauth.models.entities.User;
import ru.gb.msauth.services.UserService;

@RestController
@Log
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping("/register")
    public String registerUser(@RequestBody SignUpRequestDto signUpRequest) {
        User user = new User();
        user.setPassword(signUpRequest.getPassword());
        user.setUsername(signUpRequest.getUsername());
        userService.saveUser(user);
        return "OK";
    }

    @PostMapping("/auth")
    public AuthResponseDto auth(@RequestBody AuthRequestDto request) {
        User user = userService.findByUsernameAndPassword(request.getUsername(), request.getPassword());
        String token = jwtProvider.generateToken(user.getUsername());
        return new AuthResponseDto(token);
    }
}
