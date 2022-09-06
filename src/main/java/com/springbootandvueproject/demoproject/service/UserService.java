package com.springbootandvueproject.demoproject.service;

import com.springbootandvueproject.demoproject.dto.UserDto;
import com.springbootandvueproject.demoproject.model.User;
import com.springbootandvueproject.demoproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author Zha_Aibek@mail.com
 */
@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User save(UserDto userDto) {
        User user = new User(
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail(),
                userDto.getPassword(),
                userDto.getPasswordConfirm());
        return userRepository.save(user);
    }

}
