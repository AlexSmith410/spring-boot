package com.geekbrains.java.springboot.services;


import com.geekbrains.java.springboot.exceptions.ResourceNotFoundException;
import com.geekbrains.java.springboot.models.User;
import com.geekbrains.java.springboot.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "UserService")
public class UserService {
    private UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    public User getUserById(Long id){
        return userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Нет пользователя с таким id"));
    }

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    public void saveUser(User user){
        userRepo.save(user);
    }

    public void removeUserById(Long id){
        userRepo.deleteById(id);
    }
}
