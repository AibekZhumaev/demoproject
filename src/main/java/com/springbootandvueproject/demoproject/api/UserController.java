package com.springbootandvueproject.demoproject.api;

import com.springbootandvueproject.demoproject.dto.UserDto;
import com.springbootandvueproject.demoproject.model.User;
import com.springbootandvueproject.demoproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

/**
 * @author Zha_Aibek@mail.com
 */
@RestController
@RequestMapping(value = "/api")
public class UserController {
    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/hello")
    public String hello() {
        return "Hello!";
    }

    @PostMapping(value = "/register")
    public User register(@RequestBody UserDto userDto) {
        if (!Objects.equals(userDto.getPassword(), userDto.getPasswordConfirm()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "password do not match");
        var user = userService.save(userDto);
        return user;
    }
}
