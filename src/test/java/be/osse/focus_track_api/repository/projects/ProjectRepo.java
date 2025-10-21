package be.osse.focus_track_api.repository.projects;

import be.osse.focus_track_api.domain.projects.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepo extends CrudRepository<Project, Long> {
}
