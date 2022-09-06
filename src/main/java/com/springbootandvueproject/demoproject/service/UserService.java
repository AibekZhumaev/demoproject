package com.springbootandvueproject.demoproject.service;

import com.springbootandvueproject.demoproject.dto.UserDto;
import com.springbootandvueproject.demoproject.model.User;
import com.springbootandvueproject.demoproject.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.Objects;

/**
 * @author Zha_Aibek@mail.com
 */
@Service
@Transactional
@AllArgsConstructor
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public User save(UserDto userDto) {
        User user = new User(
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail(),
                passwordEncoder.encode(userDto.getPassword()),
                passwordEncoder.encode(userDto.getPasswordConfirm()));

        if (!Objects.equals(userDto.getPassword(), userDto.getPasswordConfirm()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "password do not match");
        return userRepository.save(user);
    }

}
