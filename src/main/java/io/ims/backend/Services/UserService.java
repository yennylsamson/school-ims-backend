package io.ims.backend.Services;

import io.ims.backend.Models.User;
import io.ims.backend.Models.UserDetails;
import io.ims.backend.Repository.UserDetailsRepository;
import io.ims.backend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.Objects;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserDetailsRepository userDetailsRepository;

    @Autowired
    public UserService(UserRepository userRepository, UserDetailsRepository userDetailsRepository) {
        this.userRepository = userRepository;
        this.userDetailsRepository = userDetailsRepository;
    }



    public User getUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public User verifyCredentials(String email, String password) throws NoSuchAlgorithmException {
        User user = userRepository.findUserByEmail(email);
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String hashedpass = DatatypeConverter.printHexBinary(digest).toUpperCase();
        System.out.println(hashedpass);
        System.out.println(user.getPassword());
        User loggedIn = new User();
        if (hashedpass.equals(user.getPassword())) {
            loggedIn.setUserID(user.getUserID());
            loggedIn.setUserRole(user.getUserRole());
        }

        return loggedIn;
    }

    @Transactional
    public void updateUser(Long userID,
                              String email,
                              String password,
                              String userRole,
                              String firstName,
                              String lastName,
                              String gender,
                              LocalDate birthDate,
                              String homeAddress,
                              String contactNumber,
                              String civilStatus) {

        UserDetails userDetails = userDetailsRepository.findById(userID)
                .orElseThrow(() -> new IllegalStateException(
                        "user with id " + userID + " does not exists"
                ));

        if (email != null &&
                email.length() > 0 &&
                !Objects.equals(userDetails.getEmail(), userDetails)) {
            userDetails.setEmail(email);
        }

        if (password != null &&
                password.length() > 0 &&
                !Objects.equals(userDetails.getPassword(), userDetails)) {
            userDetails.setPassword(password);
        }

        if (userRole != null &&
                userRole.length() > 0 &&
                !Objects.equals(userDetails.getUserRole(), userDetails)) {
            userDetails.setUserRole(userRole);
        }

        if (firstName != null &&
                firstName.length() > 0 &&
                !Objects.equals(userDetails.getFirstName(), userDetails)) {
            userDetails.setFirstName(firstName);
        }

        if (lastName != null &&
                lastName.length() > 0 &&
                !Objects.equals(userDetails.getLastName(), userDetails)) {
            userDetails.setLastName(lastName);
        }

        if (gender != null &&
                gender.length() > 0 &&
                !Objects.equals(userDetails.getGender(), userDetails)) {
            userDetails.setGender(gender);
        }

        if (birthDate != null &&
                !Objects.equals(userDetails.getBirthDate(), userDetails)) {
            userDetails.setBirthDate(birthDate);
        }

        if (homeAddress != null &&
                homeAddress.length() > 0 &&
                !Objects.equals(userDetails.getHomeAddress(), userDetails)) {
            userDetails.setHomeAddress(homeAddress);
        }

        if (contactNumber != null &&
                !Objects.equals(userDetails.getContactNumber(), userDetails)) {
            userDetails.setContactNumber(contactNumber);
        }

        if (civilStatus != null &&
                civilStatus.length() > 0 &&
                !Objects.equals(userDetails.getCivilStatus(), userDetails)) {
            userDetails.setCivilStatus(civilStatus);
        }

    }

}
