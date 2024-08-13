package com.example.userprofile.service;

import com.example.userprofile.model.Project;
import com.example.userprofile.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;
    public Project getProjectById(Long id){
        return projectRepository.findById(id).orElse(null);
    }
    public Project saveProject(Project project){
        return projectRepository.save(project);
    }
    public void deleteProject(Long id){
        Project project= projectRepository.findById(id).orElse(null);
        if(project!=null){
            projectRepository.delete(project);
        }
    }
    public Project editProject(Project updatedProject, Long id){
        Project existingProject = projectRepository.findById(id).orElseThrow(() -> new RuntimeException("Project not found"));
        existingProject.setProjectName(updatedProject.getProjectName());
        existingProject.setProjectDescription(updatedProject.getProjectDescription());
        existingProject.setProjectTechnologies(updatedProject.getProjectTechnologies());
        existingProject.setUser(updatedProject.getUser());
        existingProject.setUserPosition(updatedProject.getUserPosition());

        return projectRepository.save(existingProject);
    }
}
