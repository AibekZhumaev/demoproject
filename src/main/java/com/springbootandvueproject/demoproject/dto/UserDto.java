package com.springbootandvueproject.demoproject.dto;

import com.springbootandvueproject.demoproject.model.User;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author Zha_Aibek@mail.com
 */
@Getter
@Setter
public class UserDto implements Serializable {
    @NotNull
    private Long id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String email;
    @NotNull
    private String password;
    private String passwordConfirm;
}
