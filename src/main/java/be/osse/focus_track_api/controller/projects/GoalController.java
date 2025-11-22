package be.osse.focus_track_api.controller.projects;

import be.osse.focus_track_api.dto.projects.CreateGoalDTO;
import be.osse.focus_track_api.dto.projects.GoalDTO;
import be.osse.focus_track_api.dto.projects.UpdateGoalDTO;
import be.osse.focus_track_api.service.projects.goal.GoalService;
import be.osse.focus_track_api.service.projects.goal.GoalValidator;
import be.osse.focus_track_api.service.projects.project.ProjectValidator;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class GoalController {


    private final ProjectValidator projectValidator;
    private final GoalService goalService;
    private final GoalValidator goalValidator;

    public GoalController(
            final GoalService goalService,
            final GoalValidator goalValidator,
            final ProjectValidator projectValidator
    ) {
        this.projectValidator = projectValidator;
        this.goalService = goalService;
        this.goalValidator = goalValidator;
    }

    @GetMapping("/goals")
    @Transactional(readOnly = true)
    public List<GoalDTO> getGoalsByProjectId(
            @AuthenticationPrincipal String uuid,
            @RequestParam long id
    ) {
        if (projectValidator.validateProjectAccess(uuid, id)) {
            return goalService.getAll(id);
        }
        throw new ResponseStatusException(HttpStatus.FORBIDDEN);
    }

    @PostMapping("/goals")
    @Transactional
    public GoalDTO createGoal(
            @AuthenticationPrincipal String uuid,
            @RequestBody CreateGoalDTO data
    ) {
        if (projectValidator.validateProjectAccess(uuid, data.projectId())
                && goalValidator.validateCreateData(data)
        ) {
            return goalService.create(data.projectId(), data);
        }
        throw new ResponseStatusException(HttpStatus.FORBIDDEN);
    }

    @PutMapping("/goals")
    @Transactional
    public GoalDTO updateGoal(
            @AuthenticationPrincipal String uuid,
            @RequestBody UpdateGoalDTO data
    ) {
        if (goalValidator.validateGoalAccess(uuid, data.id())
                && goalValidator.validateUpdateData(data)) {
            return goalService.update(data);
        }
        throw new ResponseStatusException(HttpStatus.FORBIDDEN);
    }

    @DeleteMapping("/goals")
    @Transactional
    public void deleteGoal(
            @AuthenticationPrincipal String uuid,
            @RequestParam long id
    ) {
        if (goalValidator.validateGoalAccess(uuid, id)) {
            goalService.delete(id);
            return;
        }
        throw new ResponseStatusException(HttpStatus.FORBIDDEN);
    }
}
