package be.osse.focus_track_api.controller.projects;

import be.osse.focus_track_api.dto.projects.CreateStepDTO;
import be.osse.focus_track_api.dto.projects.StepDTO;
import be.osse.focus_track_api.dto.projects.UpdateStepDTO;
import be.osse.focus_track_api.service.projects.goal.GoalValidator;
import be.osse.focus_track_api.service.projects.step.StepService;
import be.osse.focus_track_api.service.projects.step.StepValidator;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class StepController {

    private final StepService stepService;
    private final StepValidator stepValidator;
    private final GoalValidator goalValidator;

    public StepController(StepService stepService, StepValidator stepValidator, GoalValidator goalValidator) {
        this.stepService = stepService;
        this.stepValidator = stepValidator;
        this.goalValidator = goalValidator;
    }

    @GetMapping("/steps")
    public List<StepDTO> getSteps(
            @AuthenticationPrincipal String uuid,
            @RequestParam long id
    ) {
        if (goalValidator.validateGoalAccess(uuid, id)
        ) {
            return stepService.getAll(id);
        }
        throw new ResponseStatusException(HttpStatus.FORBIDDEN);
    }

    @PostMapping("/steps")
    public StepDTO createStep(
            @AuthenticationPrincipal String uuid,
            @RequestBody CreateStepDTO data
    ) {
        if (goalValidator.validateGoalAccess(uuid, data.goalId())
                && stepValidator.validateCreateData(data)
        ) {
            return stepService.save(data);
        }
        throw new ResponseStatusException(HttpStatus.FORBIDDEN);
    }

    @PutMapping("/steps")
    public StepDTO updateStep(
            @AuthenticationPrincipal String uuid,
            @RequestBody UpdateStepDTO data
    ) {
        if (stepValidator.validateStepAccess(uuid, data.id())
                && stepValidator.validateUpdateData(data)
        ) {
            return stepService.update(data);
        }
        throw new ResponseStatusException(HttpStatus.FORBIDDEN);

    }

    @DeleteMapping("/steps")
    public void deleteStep(
            @AuthenticationPrincipal String uuid,
            @RequestParam long id
    ) {
        if (stepValidator.validateStepAccess(uuid, id)) {
            stepService.delete(id);
            return;
        }

        throw new ResponseStatusException(HttpStatus.FORBIDDEN);
    }
}
