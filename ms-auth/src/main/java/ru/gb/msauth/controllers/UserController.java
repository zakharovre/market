package ru.gb.msauth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.msauth.models.dtos.UserDto;
import ru.gb.msauth.services.UserService;

import java.util.List;

@RestController
@RequestMapping("api/v1/admin")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDto> findAllUsers(){
        return userService.findAllUsers();
    }
}
