package be.osse.focus_track_api.service.projects.project;

import be.osse.focus_track_api.domain.general.AppUser;
import be.osse.focus_track_api.domain.projects.Project;
import be.osse.focus_track_api.dto.projects.CreateProjectDTO;
import be.osse.focus_track_api.dto.projects.ProjectDTO;
import be.osse.focus_track_api.dto.projects.UpdateProjectDTO;
import be.osse.focus_track_api.repository.projects.ProjectRepo;
import be.osse.focus_track_api.service.general.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepo projectRepo;
    private final ProjectMapper projectMapper;
    private final AppUserService appUserService;

    @Autowired
    public ProjectService(
            final ProjectRepo projectRepo,
            final ProjectMapper projectMapper,
            final AppUserService appUserService
    ) {
        this.projectRepo = projectRepo;
        this.projectMapper = projectMapper;
        this.appUserService = appUserService;
    }

    public List<ProjectDTO> findAllByUser(String uuid) {
        return projectRepo.findByAppUserUuid(uuid).stream().map(projectMapper::toProjectDTO).toList();
    }

    @Transactional(readOnly = true)
    public boolean exists(long projectId) {
        return projectRepo.existsById(projectId);
    }

    @Transactional(readOnly = true)
    public ProjectDTO getById(Long id) {
        final Project project = projectRepo.findById(id).orElseThrow();
        return projectMapper.toProjectDTO(project);
    }

    @Transactional(readOnly = true)
    public String getAppUserUuidById(long projectId) {
        return projectRepo.findAppUserUuidById(projectId);
    }

    @Transactional
    public ProjectDTO create(
            final String uuid,
            final CreateProjectDTO createProjectDTO
    ) {
        final AppUser user = appUserService.findByUuid(uuid);
        final Project project = projectMapper.toProject(createProjectDTO, user);
        return projectMapper.toProjectDTO(projectRepo.save(project));
    }

    @Transactional
    public ProjectDTO update(UpdateProjectDTO data) {
        final Project original = projectRepo.findById(data.id()).orElseThrow();
        original.setTitle(data.title());
        original.setDescription(data.description());
        original.setArchived(data.archived());
        return projectMapper.toProjectDTO(original);
    }

    @Transactional
    public void delete(long projectId) {
        projectRepo.deleteById(projectId);
    }

}
