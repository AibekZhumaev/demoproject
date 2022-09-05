package com.springbootandvueproject.demoproject.repository;

import com.springbootandvueproject.demoproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Zha_Aibek@mail.com
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
