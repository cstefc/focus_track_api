package be.osse.focus_track_api.repository.projects;

import be.osse.focus_track_api.domain.projects.Goal;
import org.springframework.data.repository.CrudRepository;

public interface GoalRepo extends CrudRepository<Goal, Long> {
}
