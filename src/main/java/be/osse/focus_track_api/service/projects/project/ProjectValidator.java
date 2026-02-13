package be.osse.focus_track_api.service.projects.project;

import be.osse.focus_track_api.domain.projects.dto.CreateProjectDTO;
import be.osse.focus_track_api.domain.projects.dto.UpdateProjectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ProjectValidator {

    private final ProjectService service;

    @Autowired
    public ProjectValidator(final ProjectService service) {
        this.service = service;
    }

    private boolean isProjectId(long projectId) {
        return service.exists(projectId);
    }

    private boolean isTitle(String title) {
        return title != null && !title.isEmpty();
    }

    public boolean validateCreateData(CreateProjectDTO createProjectDTO) {
        return isTitle(createProjectDTO.title());
    }

    public boolean validateUpdateData(String uuid, UpdateProjectDTO updateProjectDTO) {
        return isProjectId(updateProjectDTO.id())
                && validateProjectAccess(uuid, updateProjectDTO.id())
                && isTitle(updateProjectDTO.title());
    }

    public boolean validateProjectAccess(String uuid, long projectId) {
        String projectOwner = service.getAppUserUuidById(projectId);
        return isProjectId(projectId) && Objects.equals(uuid, projectOwner);
    }

}
