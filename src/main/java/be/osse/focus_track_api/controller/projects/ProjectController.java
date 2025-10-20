package be.osse.focus_track_api.controller.projects;

import be.osse.focus_track_api.domain.projects.Project;
import be.osse.focus_track_api.service.projects.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjectController {
    private final ProjectService projectService;

    @Autowired
    public ProjectController(final ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/project")
    @ResponseBody
    public List<Project> getProjects() {
        return projectService.findAll();
    }


}
