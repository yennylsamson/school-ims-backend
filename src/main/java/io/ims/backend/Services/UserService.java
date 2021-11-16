package io.ims.backend.Services;

import io.ims.backend.Models.Professor;
import io.ims.backend.Models.User;
import io.ims.backend.Repository.ProfessorRepository;
import io.ims.backend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByEmail(String email) {
        return userRepository.findStudentByEmail(email);
    }

    public User verifyCredentials(String email, String password) {
        User user = userRepository.findStudentByEmail(email);

        System.out.println(password);
        System.out.println(user.getPassword());
        User loggedIn = new User();
        if (password.equals(user.getPassword())) {
            loggedIn.setUserID(user.getUserID());
            loggedIn.setUserRole(user.getUserRole());
        }

        return loggedIn;
    }

}
