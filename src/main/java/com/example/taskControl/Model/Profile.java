package com.example.taskControl.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String profile;
    private String createdAt;

    public Profile(String profile, String createdAt) {
        this.profile = profile;
        this.createdAt = createdAt;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile ) {
        this.profile = profile;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }


    
}
