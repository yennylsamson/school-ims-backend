package io.ims.backend.Controller;

import io.ims.backend.Models.User;
import io.ims.backend.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    //PUT USER
    @PutMapping(path = "{userID}")
    public void updateUser(
            @PathVariable("userID") Long userID,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String password,
            @RequestParam(required = false) String userRole,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String gender,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate birthDate,
            @RequestParam(required = false) String homeAddress,
            @RequestParam(required = false) String contactNumber,
            @RequestParam(required = false) String civilStatus) {
        userService.updateUser(userID, email, password, userRole, firstName, lastName, gender, birthDate, homeAddress, contactNumber, civilStatus);
    }
}
