package be.osse.focus_track_api.controller.projects;

import be.osse.focus_track_api.dto.projects.CreateProjectDTO;
import be.osse.focus_track_api.dto.projects.ProjectDTO;
import be.osse.focus_track_api.dto.projects.UpdateProjectDTO;
import be.osse.focus_track_api.service.projects.project.ProjectService;
import be.osse.focus_track_api.service.projects.project.ProjectValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class ProjectController {
    private final ProjectService projectService;
    private final ProjectValidator projectValidator;

    @Autowired
    public ProjectController(
            final ProjectService projectService,
            final ProjectValidator projectValidator
    ) {
        this.projectService = projectService;
        this.projectValidator = projectValidator;
    }

    @GetMapping("/projects")
    public List<ProjectDTO> getProject(
            @AuthenticationPrincipal String uuid,
            @RequestParam(required = false) Long id
    ) {
        if (id == null) {
            return projectService.findAllByUser(uuid);
        }
        if (projectValidator.validateProjectAccess(uuid, id)) {
            return List.of(projectService.getById(id));
        }
        throw new ResponseStatusException(HttpStatus.FORBIDDEN);
    }

    @PostMapping("/projects")
    public ProjectDTO createProject(
            @AuthenticationPrincipal String uuid,
            @RequestBody CreateProjectDTO projectData
    ) {
        if (projectValidator.validateCreateData(projectData)) {
            return projectService.create(uuid, projectData);
        }
        throw new ResponseStatusException(HttpStatus.FORBIDDEN);
    }

    @PutMapping("/projects")
    public ProjectDTO updateProject(
            @AuthenticationPrincipal String uuid,
            @RequestBody UpdateProjectDTO data
    ) {
        if (projectValidator.validateUpdateData(uuid, data)) {
            return projectService.update(data);
        }
        throw new ResponseStatusException(HttpStatus.FORBIDDEN);
    }

    @DeleteMapping("/projects/")
    public void deleteProject(
            @AuthenticationPrincipal String uuid,
            @RequestParam long id
    ) {
        if (projectValidator.validateProjectAccess(uuid, id)
        ) {
            projectService.delete(id);
        } else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
    }

}
