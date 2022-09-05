package com.springbootandvueproject.demoproject.model;

import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.data.annotation.PersistenceConstructor;

import javax.persistence.*;

/**
 * @author Zha_Aibek@mail.com
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstname;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
}
