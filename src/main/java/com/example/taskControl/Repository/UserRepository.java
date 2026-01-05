package com.example.taskControl.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.taskControl.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    public boolean existsByEmail(String email);

    public boolean existsById(Long id);
}
