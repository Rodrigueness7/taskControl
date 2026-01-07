package com.example.taskControl.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.taskControl.Model.Profile;
import com.example.taskControl.Service.ProfileService;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/profile")
public class ProfileController {
    
    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/findAllProfile")
    public ResponseEntity<List<Profile>> getAllProfile() {
       List <Profile> profile = profileService.getAllProfiles();
       return ResponseEntity.ok(profile);
    }

    @GetMapping("/findProfile/{id}")
    public ResponseEntity<Profile> getProfile(@PathVariable Long id) {
        Optional<Profile> existProfile = profileService.getProfileById(id);

        return existProfile.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping("/addProfile")
    public ResponseEntity<Profile> createProfile(@RequestBody Profile profile) {
        Profile createProfile = profileService.createProfile(profile);
        return ResponseEntity.status(HttpStatus.CREATED).body(createProfile);
    }

    @PutMapping("/updateProfile/{id}")
    public ResponseEntity<Profile> updateProfile(@PathVariable Long id, @RequestBody Profile profile) {
        
        Optional<Profile> existProfile = profileService.getProfileById(id);
        if(existProfile == null) {
            return ResponseEntity.notFound().build();
        }

        Profile updatedProfile = profileService.updateProfile(id, profile);

        return ResponseEntity.ok(updatedProfile);

    }

    @DeleteMapping("/deleteProfile/{id}")
    public ResponseEntity<Void> deleteProfile(@PathVariable Long id) {
         profileService.deleteProfile(id);

        return ResponseEntity.noContent().build();
    }
    
    
    

}
