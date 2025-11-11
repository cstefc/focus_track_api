package be.osse.focus_track_api.controller.projects;

import be.osse.focus_track_api.domain.general.AppUser;
import be.osse.focus_track_api.domain.logging.Log;
import be.osse.focus_track_api.domain.projects.Project;
import be.osse.focus_track_api.dto.projects.CreateProjectDTO;
import be.osse.focus_track_api.dto.projects.GetProjectDTO;
import be.osse.focus_track_api.service.logging.LogService;
import be.osse.focus_track_api.service.projects.ProjectMapper;
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
    private final ProjectMapper projectMapper;
    private final LogService logService;

    @Autowired
    public ProjectController(final ProjectService projectService, final ProjectMapper projectMapper, LogService logService) {
        this.projectService = projectService;
        this.projectMapper = projectMapper;
        this.logService = logService;
    }

    @GetMapping("/projects")
    public List<GetProjectDTO> getProjects(@AuthenticationPrincipal AppUser appUser) {
        List<Project> projects = projectService.findAllByUser(appUser);
        return projects.stream().map(projectMapper::toGetProjectDTO).toList();
    }

    @PostMapping("/projects")
    public Project createProject(@AuthenticationPrincipal AppUser appUser, @RequestBody CreateProjectDTO projectData) {
        Log log = new Log();
        log.setArchived(false);
        log = logService.save(log);

        final Project project = projectMapper.toProject(projectData, appUser, log);

        return projectService.save(project);
    }

}
