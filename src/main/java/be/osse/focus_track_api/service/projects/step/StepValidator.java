package be.osse.focus_track_api.service.projects.step;

import be.osse.focus_track_api.dto.projects.CreateStepDTO;
import be.osse.focus_track_api.dto.projects.UpdateStepDTO;
import be.osse.focus_track_api.service.projects.goal.GoalValidator;
import org.springframework.stereotype.Service;

@Service
public class StepValidator {

    private final GoalValidator goalValidator;
    private final StepService stepService;

    public StepValidator(GoalValidator goalValidator, StepService stepService) {
        this.goalValidator = goalValidator;
        this.stepService = stepService;
    }

    private boolean isStepId(long stepId) {
        return stepService.existsById(stepId);
    }


    private boolean isObjective(String objective) {
        return objective != null && !objective.isEmpty();
    }

    public boolean validateCreateData(CreateStepDTO data) {
        return  data.sequence() == stepService.getMaxSequenceForGoal(data.goalId()) + 1
                && isObjective(data.objective());
    }

    public boolean validateUpdateData(UpdateStepDTO data) {
        return isStepId(data.id()) && stepService.existsByIdAndSequence(data.id(), data.sequence());
    }

    public boolean validateStepAccess(String uuid, long stepId) {
        if (!isStepId(stepId)) {
            return false;
        }
        long goalId = stepService.getGoalIdById(stepId);
        return goalValidator.validateGoalAccess(uuid, goalId);
    }
}
