package io.ims.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.ims.backend.Models.Admin;
@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{
    
}
