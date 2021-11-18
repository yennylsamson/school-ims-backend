package io.ims.backend.Controller;

import io.ims.backend.Models.Admin;
import io.ims.backend.Models.Professor;
import io.ims.backend.Services.AdminService;
import io.ims.backend.Services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "admin")
@CrossOrigin
public class AdminController {
    private final AdminService adminService;

    @Autowired
    public AdminController (AdminService adminService) {
        this.adminService = adminService;
    }

    //GET ALL
    @GetMapping()
    public List<Admin> getAllAdmins(){
        return adminService.getAdmins();
    }

    //GET SINGLE USER
    @GetMapping(path = "{adminID}")
    public Optional<Admin> getAdminByID(
            @PathVariable("adminID") Long adminID){
        return adminService.getAdminByID(adminID);
    }

    //POST USER
    @PostMapping()
    public void registerNewAdmin(@RequestBody Admin admin) throws NoSuchAlgorithmException {
        adminService.addNewAdmin(admin);
    }

    //PUT USER
    @PutMapping(path = "{adminID}")
    public void updateAdmin(
            @PathVariable("adminID") Long adminID,
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
            @RequestParam(required = false) String civilStatus,
            @RequestParam(required = false) String office) throws NoSuchAlgorithmException {
        adminService.updateAdmin(adminID, email, password, userRole, firstName, lastName, gender, birthDate, homeAddress, contactNumber, civilStatus, office);
    }

    //DELETE USER
    @DeleteMapping(path = "{adminID}")
    public void deleteAdmin(
            @PathVariable("adminID") Long adminID){
        adminService.deleteAdmin(adminID);
    }
}
