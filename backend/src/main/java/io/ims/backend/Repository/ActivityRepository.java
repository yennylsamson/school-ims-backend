package io.ims.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.ims.backend.Models.Activity;
@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer>{
    
}
