package be.osse.focus_track_api.controller.projects;

import be.osse.focus_track_api.domain.general.AppUser;
import be.osse.focus_track_api.domain.projects.Project;
import be.osse.focus_track_api.dto.projects.CreateProjectDTO;
import be.osse.focus_track_api.dto.projects.ProjectDTO;
import be.osse.focus_track_api.service.general.AppUserService;
import be.osse.focus_track_api.service.projects.ProjectMapper;
import be.osse.focus_track_api.service.projects.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class ProjectController {
    private final ProjectService projectService;
    private final ProjectMapper projectMapper;
    private final AppUserService appUserService;

    @Autowired
    public ProjectController(final ProjectService projectService, final ProjectMapper projectMapper, final AppUserService appUserService) {
        this.projectService = projectService;
        this.projectMapper = projectMapper;
        this.appUserService = appUserService;
    }

    @PostMapping("/projects")
    public ProjectDTO createProject(@AuthenticationPrincipal AppUser appUser, @RequestBody CreateProjectDTO projectData) {
        final Project project = projectMapper.toProject(projectData, appUser);
        final Project saved = projectService.save(project);
        return projectMapper.toProjectDTO(saved);
    }

    @GetMapping("/projects")
    public List<ProjectDTO> getProjects(@AuthenticationPrincipal AppUser appUser) {
        List<Project> projects = projectService.findAllByUser(appUser);
        return projects.stream().map(projectMapper::toProjectDTO).toList();
    }

    @GetMapping("/projects/{id}")
    @Transactional(readOnly = true)
    public ProjectDTO getProject(@AuthenticationPrincipal AppUser appUser, @PathVariable Long id) {
        final AppUser user = appUserService.findByUuid(appUser.getUuid());
        final Project project = projectService.findById(id);
        if (user.getProjects().contains(project)) {
            return projectMapper.toProjectDTO(project);
        }
        throw new ResponseStatusException(HttpStatus.FORBIDDEN);
    }

    @PutMapping("/projects/{id}")
    @Transactional
    public ProjectDTO updateProject(@AuthenticationPrincipal AppUser appUser,
                                    @PathVariable Long id,
                                    @RequestBody CreateProjectDTO projectData) {
        final AppUser user = appUserService.findByUuid(appUser.getUuid());
        final Project project = projectService.findById(id);
        if (user.getProjects().contains(project)) {
            final Project updated = projectMapper.toProject(projectData, appUser);
            final Project saved = projectService.update(id, updated);
            return projectMapper.toProjectDTO(saved);
        }
        throw new ResponseStatusException(HttpStatus.FORBIDDEN);
    }

    @DeleteMapping("/projects/{id}")
    @Transactional
    public boolean deleteProject(@AuthenticationPrincipal AppUser appUser, @PathVariable Long id) {
        final AppUser userWithSession = appUserService.findByUuid(appUser.getUuid());
        final Project project = projectService.findById(id);
        if (userWithSession.getProjects().contains(project)) {
            projectService.delete(project);
            return true;
        } else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
    }


}
