package com.springbootandvueproject.demoproject.repository;

import com.springbootandvueproject.demoproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Zha_Aibek@mail.com
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //select * from user u where u.email = :email
    Optional<User> findByEmail(String email);
}
