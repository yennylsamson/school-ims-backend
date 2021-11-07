package io.ims.backend.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.ims.backend.Models.User;
import io.ims.backend.Repository.UserRepository;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {
    @Autowired
    private UserRepository userRepository;

    //GET ALL
    @GetMapping("/")
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    //GET SINGLE USER
    @GetMapping("/{userID}")
    public User getUser(@PathVariable Integer userID){
        return userRepository.findById(userID).orElse(null);
    }

    //POST USER
    @PostMapping("/")
    public User postUser(@RequestBody User user){
        return userRepository.save(user);
    }

    //PUT USER
    @PutMapping("/")
    public User putUser(@RequestBody User user){
        User oldUser = userRepository.findById(user.getUserID()).orElse(null);
        oldUser.setEmail(user.getEmail());
        oldUser.setPassword(user.getPassword());
        oldUser.setUserRole(user.getUserRole());
        return userRepository.save(oldUser);
    }

    //DELETE USER
    @DeleteMapping("/{userID}")
    public Integer deleteUser(@PathVariable Integer userID){
        userRepository.deleteById(userID);
        return userID;
    }
}
