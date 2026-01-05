package com.example.taskControl.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.taskControl.Model.Profile;



@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

    public boolean existByProfile(Profile profile);

    public boolean existsById(Long id);
    
    
}
