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

import io.ims.backend.Models.UserDetails;
import io.ims.backend.Repository.UserDetailsRepository;

@RestController
@RequestMapping("/userDetails")
@CrossOrigin
public class UserDetailsController {
    @Autowired
    private UserDetailsRepository userdetailsRepository;

    //GET ALL
    @GetMapping("/")
    public List<UserDetails> getUserDetails(){
        return userdetailsRepository.findAll();
    }

    //GET SINGLE USER
    @GetMapping("/{detailsID}")
    public UserDetails getUserDetails(@PathVariable Integer detailsID){
        return userdetailsRepository.findById(detailsID).orElse(null);
    }

    //POST USER
    @PostMapping("/")
    public UserDetails postUserDetails(@RequestBody UserDetails userdetails){
        return userdetailsRepository.save(userdetails);
    }

    //PUT USER
    @PutMapping("/")
    public UserDetails putUserDetails(@RequestBody UserDetails userdetails){
        UserDetails oldUserDetails = userdetailsRepository.findById(userdetails.getDetailsID()).orElse(null);
        oldUserDetails.setFirstName(userdetails.getFirstName());
        oldUserDetails.setLastName(userdetails.getLastName());
        oldUserDetails.setGender(userdetails.getGender());
        oldUserDetails.setAge(userdetails.getAge());
        oldUserDetails.setBirthDate(userdetails.getBirthDate());
        oldUserDetails.setHomeAddress(userdetails.getHomeAddress());
        oldUserDetails.setContactNumber(userdetails.getContactNumber());
        oldUserDetails.setCivilStatus(userdetails.getCivilStatus());
        return userdetailsRepository.save(oldUserDetails);
    }

    //DELETE USER
    @DeleteMapping("/{detailsID}")
    public Integer deleteUserDetails(@PathVariable Integer detailsID){
        userdetailsRepository.deleteById(detailsID);
        return detailsID;
    }
}
