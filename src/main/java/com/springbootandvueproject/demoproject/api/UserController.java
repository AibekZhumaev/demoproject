package com.springbootandvueproject.demoproject.api;

import com.springbootandvueproject.demoproject.dto.UserDto;
import com.springbootandvueproject.demoproject.model.User;
import com.springbootandvueproject.demoproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Zha_Aibek@mail.com
 */
@RestController
@RequestMapping(value = "/api")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/hello")
    public String hello() {
        return "Hello!";
    }

    record RegisterResponse(String firstName, String lastName, String email, String password, String passwordConfirm) {
    }

    @PostMapping(value = "/register")
    public RegisterResponse registerUserAccount(@RequestBody UserDto userDto) {
        var user = userService.register(userDto);
        return new RegisterResponse(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(), user.getPasswordConfirm());
    }

    record LoginResponse(String firstName, String lastName, String email) {
    }

    @PostMapping(value = "/login")
    public LoginResponse login(@RequestBody UserDto userDto) {
        var user = userService.login(userDto.getEmail(), userDto.getPassword());
        return new LoginResponse(user.getFirstName(), user.getLastName(), user.getEmail());
    }

}
