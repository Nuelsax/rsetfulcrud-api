package com.example.retfulapi2.service.impl;

import com.example.retfulapi2.exception.ResourceNotFoundException;
import com.example.retfulapi2.models.User;
import com.example.retfulapi2.repository.UserRepository;
import com.example.retfulapi2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl  implements UserService {
    private UserRepository userRepository;
     @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserbyId(long id) {
        return userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("User not found with id :" + id));

    }

    @Override
    public User updateUser(User user, long id) {
        User exisitingUser = this.userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("User not found with id :" + id));
        exisitingUser.setFirstName(user.getFirstName());
        exisitingUser.setLastName(user.getLastName());
        exisitingUser.setEmail(user.getEmail());
        System.out.println("user updated");
        return this.userRepository.save(exisitingUser);

    }

    @Override
    public ResponseEntity<User> deleteUser(long userId) {
        User exisitingUser = this.userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User not found with id :" + userId));
        this.userRepository.delete(exisitingUser);
        return ResponseEntity.ok().build();
    }
}
