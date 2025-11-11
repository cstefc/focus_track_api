package be.osse.focus_track_api.service.projects;

import be.osse.focus_track_api.domain.general.AppUser;
import be.osse.focus_track_api.domain.logging.Log;
import be.osse.focus_track_api.domain.projects.Project;
import be.osse.focus_track_api.dto.projects.CreateProjectDTO;
import be.osse.focus_track_api.dto.projects.GetProjectDTO;
import org.springframework.stereotype.Service;

@Service
public class ProjectMapper {
    public GetProjectDTO toGetProjectDTO(Project project) {
        return new GetProjectDTO(project.getId(), project.getUser().getUuid(), project.getName(), project.getDescription(), project.isArchived());
    }

    public Project toProject(CreateProjectDTO dto, AppUser appUser, Log log) {
        Project project = new Project();
        project.setUser(appUser);
        project.setLog(log);
        project.setName(dto.name());
        project.setDescription(dto.description());
        project.setArchived(false);
        return project;
    }
}
