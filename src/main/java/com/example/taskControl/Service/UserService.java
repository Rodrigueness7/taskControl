package com.example.taskControl.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.taskControl.Model.User;
import com.example.taskControl.Repository.UserRepository;

@Service
public class UserService {
    
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        if(userRepository.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("Email already in use");
        }
        return userRepository.save(user);
    }

    public void updateUser(Long id, User updateUser) {
        Optional<User> existingUserOpt = userRepository.findById(id);
        if(!existingUserOpt.isPresent()) {
            throw new IllegalArgumentException("User not found");
        }

        User existingUser = existingUserOpt.get(); 
        existingUser.setUsername(updateUser.getUsername());
        existingUser.setEmail(updateUser.getEmail());
        existingUser.setPassword(updateUser.getPassword());
        existingUser.setProfile(updateUser.getProfile());
        existingUser.setCreatedAt(updateUser.getCreatedAt());
        userRepository.save(existingUser);
    }
    
    
    public void deleteUser(Long id) {
        if(!userRepository.existsById(id)) {
            throw new IllegalArgumentException("User not found");
        }
        userRepository.deleteById(id);
        
    }

}
