package com.example.retfulapi2.service;

import com.example.retfulapi2.models.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    User getUserbyId(long id);
    User saveUser(User user);
    User updateUser(User user, long id);
    ResponseEntity<User> deleteUser(long userId);
}
