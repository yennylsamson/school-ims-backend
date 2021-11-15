package io.ims.backend.Services;

import io.ims.backend.Models.Admin;
import io.ims.backend.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AdminService {
    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<Admin> getAdmins() {
        return adminRepository.findAll();
    }

    public Optional<Admin> getAdminByID(Long adminID) {
        return adminRepository.findById(adminID);
    }

    public void addNewAdmin(Admin admin) {
        adminRepository.save(admin);
    }

    public void deleteAdmin(Long userID) {
        boolean exists = adminRepository.existsById(userID);
        if (!exists) {
            throw new IllegalStateException("admin with id " + userID + " does not exists");
        }
        adminRepository.deleteById(userID);
    }

    @Transactional
    public void updateAdmin(Long userID,
                                String email,
                                String password,
                                String userRole,
                                String firstName,
                                String lastName,
                                String gender,
                                LocalDate birthDate,
                                String homeAddress,
                                String contactNumber,
                                String civilStatus,
                                String office) {
        Admin admin = adminRepository.findById(userID)
                .orElseThrow(() -> new IllegalStateException(
                        "admin with id " + userID + " does not exists"
                ));

        if (email != null &&
                email.length() > 0 &&
                !Objects.equals(admin.getEmail(), admin)) {
            admin.setEmail(email);
        }

        if (password != null &&
                password.length() > 0 &&
                !Objects.equals(admin.getPassword(), admin)) {
            admin.setPassword(password);
        }

        if (userRole != null &&
                userRole.length() > 0 &&
                !Objects.equals(admin.getUserRole(), admin)) {
            admin.setUserRole(userRole);
        }

        if (firstName != null &&
                firstName.length() > 0 &&
                !Objects.equals(admin.getFirstName(), admin)) {
            admin.setFirstName(firstName);
        }

        if (lastName != null &&
                lastName.length() > 0 &&
                !Objects.equals(admin.getLastName(), admin)) {
            admin.setLastName(lastName);
        }

        if (gender != null &&
                gender.length() > 0 &&
                !Objects.equals(admin.getGender(), admin)) {
            admin.setGender(gender);
        }

        if (birthDate != null &&
                !Objects.equals(admin.getBirthDate(), admin)) {
            admin.setBirthDate(birthDate);
        }

        if (homeAddress != null &&
                homeAddress.length() > 0 &&
                !Objects.equals(admin.getHomeAddress(), admin)) {
            admin.setHomeAddress(homeAddress);
        }

        if (contactNumber != null &&
                !Objects.equals(admin.getContactNumber(), admin)) {
            admin.setContactNumber(contactNumber);
        }

        if (civilStatus != null &&
                civilStatus.length() > 0 &&
                !Objects.equals(admin.getCivilStatus(), admin)) {
            admin.setCivilStatus(civilStatus);
        }

        if (office != null &&
                office.length() > 0 &&
                !Objects.equals(admin.getOffice(), admin)) {
            admin.setOffice(office);
        }

    }

}
