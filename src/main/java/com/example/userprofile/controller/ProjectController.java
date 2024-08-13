package com.example.userprofile.controller;

import com.example.userprofile.model.Project;
import com.example.userprofile.model.User;
import com.example.userprofile.service.ProjectService;
import com.example.userprofile.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public String getProjectDetail(@PathVariable Long id, Model model){
        model.addAttribute("project", projectService.getProjectById(id));
        return "projectDetailPage";
    }
    @GetMapping("/create/{userId}")
    public String getCreateProjectForm(@PathVariable Long userId, Model model){
        User user = userService.getUserById(userId);
        Project project = new Project();
        project.setUser(user);
        model.addAttribute("project", project);
        return "addProjectForm";
    }
    @PostMapping("/create")
    public String addProject(@ModelAttribute Project project){
        projectService.saveProject(project);
        return "redirect:/users/" + project.getUser().getId();
    }
    @GetMapping("/delete/{id}")
    public String deleteProject(@PathVariable Long id) {
        Project project = projectService.getProjectById(id);
        if (project != null) {
            projectService.deleteProject(id);
            return "redirect:/users/" + project.getUser().getId();
        }
        return "home";
    }
    @GetMapping("/edit/{id}")
    public String getEditProjectForm(@PathVariable Long id, Model model){
        Project project = projectService.getProjectById(id);
        if(project == null){
            return "redirect:/users/" + project.getUser().getId();
        }
        model.addAttribute("project", project);
        return "editProjectForm";
    }
    @PostMapping("/edit/{id}")
    public String editProject(@PathVariable Long id, @ModelAttribute Project project){
        projectService.editProject(project, id);
        return "redirect:/users/" + project.getUser().getId();
    }
}
