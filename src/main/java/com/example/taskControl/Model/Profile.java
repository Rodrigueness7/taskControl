package com.example.taskControl.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Profiles")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String profile;
    private String createdAt;


    public Profile(String profile, String createdAt, Long id) {
        this.id = id;
        this.profile = profile;
        this.createdAt = createdAt;
    }

    public Profile() {}

    public Long getId() {
        return id;
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
