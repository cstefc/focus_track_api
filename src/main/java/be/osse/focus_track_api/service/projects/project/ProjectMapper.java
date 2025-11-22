package be.osse.focus_track_api.service.projects.project;

import be.osse.focus_track_api.domain.general.AppUser;
import be.osse.focus_track_api.domain.projects.Project;
import be.osse.focus_track_api.dto.projects.CreateProjectDTO;
import be.osse.focus_track_api.dto.projects.ProjectDTO;
import org.springframework.stereotype.Service;

@Service
public class ProjectMapper {

    public ProjectDTO toProjectDTO(Project project) {
        return new ProjectDTO(project.getId(), project.getTitle(), project.getDescription(), project.isArchived());
    }

    public Project toProject(CreateProjectDTO dto, AppUser appUser) {
        Project project = new Project();
        project.setUser(appUser);
        project.setTitle(dto.title());
        project.setDescription(dto.description());
        project.setArchived(dto.archived() );
        return project;
    }
}
