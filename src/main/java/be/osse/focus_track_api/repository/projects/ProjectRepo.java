package be.osse.focus_track_api.repository.projects;

import be.osse.focus_track_api.domain.projects.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepo extends CrudRepository<Project, Long> {
    List<Project> findByAppUserUuid(String uuid);
}
