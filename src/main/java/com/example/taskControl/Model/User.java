package com.example.taskControl.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;

    @OneToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;
    private String createdAt;

    public User(String username, String email, String password, Profile profile, String createdAt) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.profile = profile;
        this.createdAt = createdAt;
    }

    public String getUsername() {
        return username;
    };

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getCreatedAt() {
        return createdAt;
    }   

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    
    
}
