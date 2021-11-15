package io.ims.backend.Controller;

import io.ims.backend.Models.User;
import io.ims.backend.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "users")
@CrossOrigin
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //SIGN IN
    @PostMapping()
    public User signIn(
            @RequestBody User user){
        User loggedIn = userService.verifyCredentials(user.getEmail(),user.getPassword());

        return  loggedIn;
    }
}
