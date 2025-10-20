package be.osse.focus_track_api.service.projects;

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

    public List<Project> findAll() {
        for (Project project : projectRepo.findAll()) {
            System.out.println(project.getName());
        }
        return (List<Project>) projectRepo.findAll();
    }

}
