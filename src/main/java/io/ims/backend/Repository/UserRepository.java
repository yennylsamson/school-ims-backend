package io.ims.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.ims.backend.Models.User;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    @Query("SELECT * FROM user WHERE email = ?1")
    Optional<User> findStudentByEmail(String email);
}
