package com.services.user.controller;

import com.services.user.model.User;
import com.services.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private IUserService userService;

    public UserController(IUserService userService)
    {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<User>  creatUser(@RequestBody User user)
    {
       User newUser =  userService.createUser(user);
        return ResponseEntity.ok(newUser);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id)
    {
        User user=  userService.getUser(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUser()
    {
        List<User> users=  userService.getAllUsers();
       
        return ResponseEntity.ok(users);
    }

    @PutMapping("/users")
    public ResponseEntity<Boolean> updateUser(@RequestBody User user)
    {
        userService.updateUser(user);
        return ResponseEntity.ok(true);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Boolean> removeUser(@PathVariable String id)
    {
        userService.deleteUser(id);
        return  ResponseEntity.ok(true);
    }
}
