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

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findStudentByEmail(email);
    }

}
