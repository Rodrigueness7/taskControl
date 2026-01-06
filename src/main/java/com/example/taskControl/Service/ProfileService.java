package com.example.taskControl.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.taskControl.Model.Profile;
import com.example.taskControl.Repository.ProfileRepository;

@Service
public class ProfileService {
    
    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    public Optional<Profile> getProfileById(Long id) {
        return profileRepository.findById(id);
    }

    public Profile createProfile(Profile profile) {
        if(profileRepository.existsByProfile(profile.getProfile())) {
            throw new IllegalArgumentException("Profile already exists");
        } 
        return profileRepository.save(profile);
    }

    public void updateProfile(Long id, Profile updateProfile) throws IllegalAccessException {
        Optional<Profile> existingProfileOpt = profileRepository.findById(id);
        if(!existingProfileOpt.isPresent()) {
            throw new IllegalAccessException("Profile not found");
        } 

        Profile existingProfile = existingProfileOpt.get();
        existingProfile.setProfile(updateProfile.getProfile());
        existingProfile.setCreatedAt(updateProfile.getCreatedAt());
        profileRepository.save(existingProfile);
    }

    public void deleteProfile(Long id) {
        if(!profileRepository.existsById(id)) {
            throw new IllegalArgumentException("Profile not found");
        }
        profileRepository.deleteById(id);
    }
}

