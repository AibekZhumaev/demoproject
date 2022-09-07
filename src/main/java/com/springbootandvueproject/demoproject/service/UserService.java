package com.springbootandvueproject.demoproject.service;

import com.springbootandvueproject.demoproject.dto.UserDto;
import com.springbootandvueproject.demoproject.security.Login;
import com.springbootandvueproject.demoproject.model.User;
import com.springbootandvueproject.demoproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

/**
 * @author Zha_Aibek@mail.com
 */
@Service
//@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final String accessTokenSecret;
    private final String refreshTokenSecret;

    public UserService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            @Value("${application.security.access-token-secret}") String accessTokenSecret,
            @Value("${application.security.refresh-token-secret}") String refreshTokenSecret) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.accessTokenSecret = accessTokenSecret;
        this.refreshTokenSecret = refreshTokenSecret;
    }

    public User register(UserDto userDto) {
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

    public Login login(String email, String password) {
        var user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "invalid credentials"));

        if (!passwordEncoder.matches(password, user.getPassword()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "invalid credentials");
        return Login.of(user.getId(), accessTokenSecret, refreshTokenSecret);
    }
}
