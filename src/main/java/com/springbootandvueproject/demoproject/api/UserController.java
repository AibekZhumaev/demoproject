package com.springbootandvueproject.demoproject.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zha_Aibek@mail.com
 */
@RestController
@RequestMapping(value = "/api")
public class UserController {

    @GetMapping(value = "/hello")
    public String hello() {
        return "Hello!";
    }
}
