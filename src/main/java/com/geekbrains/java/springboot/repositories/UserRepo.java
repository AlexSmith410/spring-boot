package com.geekbrains.java.springboot.repositories;

import com.geekbrains.java.springboot.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepo extends JpaRepository<User, Long> {
}
