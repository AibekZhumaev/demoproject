package com.springbootandvueproject.demoproject.service;

import com.springbootandvueproject.demoproject.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
