package be.osse.focus_track_api.service.projects.goal;

import be.osse.focus_track_api.domain.projects.dto.CreateGoalDTO;
import be.osse.focus_track_api.domain.projects.dto.UpdateGoalDTO;
import be.osse.focus_track_api.service.projects.project.ProjectValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoalValidator {
    private final GoalService goalService;
    private final ProjectValidator projectValidator;

    @Autowired
    public GoalValidator(GoalService goalService, ProjectValidator projectValidator) {
        this.goalService = goalService;
        this.projectValidator = projectValidator;
    }

    private boolean isGoalId(long goalId) {
        return goalService.exists(goalId);
    }

    public boolean validateCreateData(CreateGoalDTO data) {
        return data.title() != null && !data.title().isEmpty();
    }

    public boolean validateUpdateData(UpdateGoalDTO data) {
        return isGoalId(data.id())
                && data.title() != null
                && !data.title().isEmpty();
    }

    public boolean validateGoalAccess(String uuid, long goalId) {
        if (!isGoalId(goalId)) {
            return false;
        }
        long projectId = goalService.getParentId(goalId);
        return projectValidator.validateProjectAccess(uuid, projectId);
    }

}
