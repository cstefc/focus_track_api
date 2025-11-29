package be.osse.focus_track_api.repository.projects;

import be.osse.focus_track_api.domain.projects.Goal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GoalRepo extends CrudRepository<Goal, Long> {
    List<Goal> findAllByProjectId(long ProjectId);

    void deleteById(long id);

    @Query("SELECT p.id FROM Goal g JOIN g.project p WHERE g.id = :goalId")
    int findProjectIdById(long goalId);
}
