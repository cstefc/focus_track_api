package be.osse.focus_track_api.service.projects;

import be.osse.focus_track_api.domain.general.AppUser;
import be.osse.focus_track_api.domain.projects.Project;
import be.osse.focus_track_api.repository.projects.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepo projectRepo;

    @Autowired
    public ProjectService(final ProjectRepo projectRepo) {
        this.projectRepo = projectRepo;
    }

    public List<Project> findAllByUser(AppUser appUser) {
        return projectRepo.findByAppUserUuid(appUser.getUuid());
    }

    public Project findById(Long id) {
        return projectRepo.findById(id).orElse(null);
    }

    public Project save(Project project) {
        return projectRepo.save(project);
    }

    public void delete(Project project) {
        final AppUser user = project.getUser();
        user.getProjects().remove(project);
        projectRepo.delete(project);
    }

    public Project update(long id, Project project) {
        final Project original = projectRepo.findById(id).orElseThrow();
        original.setTitle(project.getTitle());
        original.setDescription(project.getDescription());
        original.setArchived(project.isArchived());
        return projectRepo.save(original);
    }
}
