package com.springbootandvueproject.demoproject.api;

import com.springbootandvueproject.demoproject.dto.UserDto;
import com.springbootandvueproject.demoproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Zha_Aibek@mail.com
 */
@RestController
@RequestMapping(value = "/api")
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
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

    record LoginResponse(String token) {
    }

    record LoginRequest(String email, String password) {
    }

    @PostMapping(value = "/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest, HttpServletResponse response) {
        var login = userService.login(loginRequest.email(), loginRequest.password());

        Cookie cookie = new Cookie("refresh_token", login.getRefreshToken().getToken());
        cookie.setMaxAge(3600);
        cookie.setHttpOnly(true);
        cookie.setPath("/api");

        response.addCookie(cookie);

        return new LoginResponse(login.getAccessToken().getToken());
    }

}
