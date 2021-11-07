package io.ims.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.ims.backend.Models.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    
}
