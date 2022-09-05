package com.springbootandvueproject.demoproject.api;

import com.springbootandvueproject.demoproject.model.User;
import com.springbootandvueproject.demoproject.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

/**
 * @author Zha_Aibek@mail.com
 */
@RestController
@RequestMapping(value = "/api")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping(value = "/hello")
    public String hello() {
        return "Hello!";
    }

    @PostMapping(value = "/register")
    public User register(@RequestBody User user) {
        return userRepository.save(user);
    }
}
