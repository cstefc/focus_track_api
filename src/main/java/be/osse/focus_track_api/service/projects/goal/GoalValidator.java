package be.osse.focus_track_api.service.projects.goal;

import be.osse.focus_track_api.dto.projects.CreateGoalDTO;
import be.osse.focus_track_api.dto.projects.UpdateGoalDTO;
import be.osse.focus_track_api.repository.projects.GoalRepo;
import be.osse.focus_track_api.service.projects.project.ProjectValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoalValidator {
    private final GoalRepo goalRepo;
    private final ProjectValidator projectValidator;
    private final GoalService goalService;

    @Autowired
    public GoalValidator(final GoalRepo goalRepo, ProjectValidator projectValidator, GoalService goalService) {
        this.goalRepo = goalRepo;
        this.projectValidator = projectValidator;
        this.goalService = goalService;
    }

    private boolean isGoalId(long goalId) {
        return goalRepo.existsById(goalId);
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
