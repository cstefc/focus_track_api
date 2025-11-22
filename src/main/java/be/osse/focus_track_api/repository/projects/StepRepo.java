package be.osse.focus_track_api.repository.projects;

import be.osse.focus_track_api.domain.projects.Step;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StepRepo extends CrudRepository<Step, Long> {
    List<Step> findAllByGoalId(long goalId);

    boolean existsById(long id);

    boolean existsByIdAndSequence(long id, int sequence);

    @Query("SELECT g.id FROM Step s JOIN s.goal g where s.id = :id")
    long findGoalIdById(@Param("id") long id);

    @Query("SELECT COALESCE(MAX(s.sequence), 0) FROM Step s where s.goal.id = :goalId")
    int findMaxSequenceForGoal(@Param("goalId")long goalId);
}
