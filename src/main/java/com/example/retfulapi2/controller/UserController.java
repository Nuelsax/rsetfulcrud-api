package com.example.retfulapi2.controller;

import com.example.retfulapi2.exception.ResourceNotFoundException;
import com.example.retfulapi2.models.User;
import com.example.retfulapi2.repository.UserRepository;
import com.example.retfulapi2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    //get all users
    @GetMapping
    public List<User> getAllUsers() {
        return this.userService.getAllUser();
    }

    //get User by Id
    @GetMapping("/{id}")
    public User getUserById(@PathVariable(value = "id") long userId) {
        return this.userService.getUserbyId(userId);

    }

    //Create user
    @PostMapping
    public User createUser(@RequestBody User user) {
        System.out.println("User Sucessfully added Added");
        return userService.saveUser(user);


    }
    @PutMapping("/{id}")
    public User updateUser(@RequestBody User user, @PathVariable("id") long userId) {
          return userService.updateUser(user,userId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") long userId) {
        return userService.deleteUser(userId);
    }


}
