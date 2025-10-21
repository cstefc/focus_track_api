package be.osse.focus_track_api.controller.projects;

import be.osse.focus_track_api.domain.general.AppUser;
import be.osse.focus_track_api.domain.projects.Project;
import be.osse.focus_track_api.dto.project.CreateProjectDTO;
import be.osse.focus_track_api.repository.projects.ProjectRepo;
import be.osse.focus_track_api.service.projects.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjectController {
    private final ProjectService projectService;
    private final ProjectRepo projectRepo;

    @Autowired
    public ProjectController(final ProjectService projectService, ProjectRepo projectRepo) {
        this.projectService = projectService;
        this.projectRepo = projectRepo;
    }

    @GetMapping("/projects")
    public List<Project> getProjects(@AuthenticationPrincipal AppUser user) {
        System.out.println(user.getUsername() + " " + user.getEmail());
        return projectService.findAll();
    }

    @PostMapping("/projects")
    public Project createProject(@AuthenticationPrincipal AppUser user, @RequestBody CreateProjectDTO projectData) {
        final Project project = new Project(user, projectData);
        return projectRepo.save(project);
    }

}
