package io.ims.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.ims.backend.Models.UserDetails;
@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long>{
    
}
