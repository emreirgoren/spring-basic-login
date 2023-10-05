package com.example.springbasiclogin.services;

import com.example.springbasiclogin.entities.User;
import com.example.springbasiclogin.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User newUser) {
        return userRepository.save(newUser);
    }

    public String login(String username, String password) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return "Kullanıcı Girişi Başarılıdır.";
        } else
            return "Kullanıcı adı veya şifre Hatalıdır.";
    }
}
