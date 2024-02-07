package com.example.repository;


import com.example.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUserName(String username);
    @Transactional
        //Use this annotation for delete and persist
    void deleteByUserName(String username);
    List<User> findAllByRoleDescriptionIgnoreCase(String description);
}
