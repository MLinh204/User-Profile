package com.example.userprofile.service;

import com.example.userprofile.model.User;
import com.example.userprofile.repository.ProjectRepository;
import com.example.userprofile.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUser(){
        return userRepository.findAll();
    }
    public User getUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }
    public User saveUser(User user){
        return userRepository.save(user);
    }
    public void deleteUser(Long id){
        User user = userRepository.findById(id).orElse(null);
        if (user != null){
            projectRepository.deleteAll(user.getProjects());
            userRepository.delete(user);
        }
    }
    public User editUser (Long id, User updatedUser){
        User existingUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        existingUser.setName(updatedUser.getName());
        existingUser.setAge(updatedUser.getAge());
        existingUser.setPosition(updatedUser.getPosition());
        existingUser.setYearOfExperience(updatedUser.getYearOfExperience());
        existingUser.setProfilePicture(updatedUser.getProfilePicture());

        return userRepository.save(existingUser);
    }
}
