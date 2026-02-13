package be.osse.focus_track_api.service.projects.goal;

import be.osse.focus_track_api.domain.projects.Goal;
import be.osse.focus_track_api.domain.projects.Project;
import be.osse.focus_track_api.domain.projects.dto.CreateGoalDTO;
import be.osse.focus_track_api.domain.projects.dto.GoalDTO;
import be.osse.focus_track_api.domain.projects.dto.UpdateGoalDTO;
import be.osse.focus_track_api.repository.projects.GoalRepo;
import be.osse.focus_track_api.repository.projects.ProjectRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GoalService {

    private final GoalRepo goalRepo;
    private final GoalMapper goalMapper;
    private final ProjectRepo projectRepo;

    public GoalService(final GoalRepo goalRepo, final GoalMapper goalMapper, final ProjectRepo projectRepo) {
        this.goalRepo = goalRepo;
        this.goalMapper = goalMapper;
        this.projectRepo = projectRepo;
    }

    @Transactional(readOnly = true)
    public List<GoalDTO> getAll(long projectId) {
        List<Goal> goals = goalRepo.findAllByProjectId(projectId);
        return goals.stream().map(goalMapper::toGoalDTO).toList();
    }

    @Transactional(readOnly = true)
    public boolean exists(long goalId){
        return goalRepo.existsById(goalId);
    }

    @Transactional(readOnly = true)
    public long getParentId(long goalId) {
        return goalRepo.findProjectIdById(goalId);
    }

    @Transactional
    public GoalDTO create(long projectId, CreateGoalDTO data) {
        Project project = projectRepo.findById(projectId).orElseThrow();
        Goal goal = goalMapper.toGoal(project, data);
        return goalMapper.toGoalDTO(goalRepo.save(goal));
    }

    @Transactional
    public GoalDTO update(UpdateGoalDTO data) {
        Goal goal = goalRepo.findById(data.id()).orElseThrow();
        goal.setTitle(data.title());
        goal.setDescription(data.description());
        goal.setPriority(data.priority());
        goal.setEstimated(data.estimated());
        return goalMapper.toGoalDTO(goal);
    }

    @Transactional
    public void delete(long goalId) {
        goalRepo.deleteById(goalId);
    }

}