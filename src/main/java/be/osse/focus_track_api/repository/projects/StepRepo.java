package be.osse.focus_track_api.repository.projects;

import be.osse.focus_track_api.domain.projects.Step;
import org.springframework.data.repository.CrudRepository;

public interface StepRepo extends CrudRepository<Step, Long> {
}
