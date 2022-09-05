package com.springbootandvueproject.demoproject.service;

import com.springbootandvueproject.demoproject.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Zha_Aibek@mail.com
 */

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

}
