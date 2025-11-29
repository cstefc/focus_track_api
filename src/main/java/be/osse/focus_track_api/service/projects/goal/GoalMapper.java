package be.osse.focus_track_api.service.projects.goal;

import be.osse.focus_track_api.domain.projects.Goal;
import be.osse.focus_track_api.domain.projects.Project;
import be.osse.focus_track_api.dto.projects.CreateGoalDTO;
import be.osse.focus_track_api.dto.projects.GoalDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoalMapper {
    public GoalDTO toGoalDTO(Goal goal) {
        return new GoalDTO(
                goal.getId(),
                goal.getTitle(),
                goal.getDescription(),
                goal.getPriority().ordinal(),
                goal.getEstimated()
        );
    }

    public Goal toGoal(Project project, CreateGoalDTO data) {
        final Goal goal = new Goal();
        goal.setTitle(data.title());
        goal.setDescription(data.description());
        goal.setSteps(List.of());
        goal.setEstimated(data.estimated());
        goal.setPriority(data.priority());
        goal.setProject(project);

        return goal;
    }
}
