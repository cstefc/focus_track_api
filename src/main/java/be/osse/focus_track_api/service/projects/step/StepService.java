package be.osse.focus_track_api.service.projects.step;

import be.osse.focus_track_api.domain.predefined.Status;
import be.osse.focus_track_api.domain.projects.Goal;
import be.osse.focus_track_api.domain.projects.Step;
import be.osse.focus_track_api.dto.projects.CreateStepDTO;
import be.osse.focus_track_api.dto.projects.StepDTO;
import be.osse.focus_track_api.dto.projects.UpdateStepDTO;
import be.osse.focus_track_api.repository.projects.StepRepo;
import be.osse.focus_track_api.service.projects.goal.GoalService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Comparator;
import java.util.List;

@Service
public class StepService {
    private final StepRepo stepRepo;
    private final StepMapper stepMapper;
    private final GoalService goalService;

    public StepService(StepRepo stepRepo, StepMapper stepMapper, GoalService goalService) {
        this.stepRepo = stepRepo;
        this.stepMapper = stepMapper;
        this.goalService = goalService;
    }

    @Transactional(readOnly = true)
    public boolean existsById(long id) {
        return stepRepo.existsById(id);
    }

    @Transactional(readOnly = true)
    public boolean existsByIdAndSequence(long id, int sequence) {
        return stepRepo.existsByIdAndSequence(id, sequence);
    }

    @Transactional(readOnly = true)
    public long getGoalIdById(long id) {
        return stepRepo.findGoalIdById(id);
    }

    @Transactional(readOnly = true)
    public int getMaxSequenceForGoal(long goalId) {
        return stepRepo.findMaxSequenceForGoal(goalId);
    }

    @Transactional(readOnly = true)
    public List<StepDTO> getAll(long goalId) {
        final List<Step> steps = stepRepo.findAllByGoalId(goalId);
        return steps.stream().map(stepMapper::toStepDTO).toList();
    }

    @Transactional
    public StepDTO save(CreateStepDTO data) {
        final Goal goal = goalService.getById(data.goalId());
        final Step step = stepMapper.toStep(data, goal);
        return stepMapper.toStepDTO(stepRepo.save(step));
    }

    @Transactional
    public StepDTO update(UpdateStepDTO data) {
        final Step step = stepRepo.findById(data.id()).orElseThrow();
        final Status status = Status.values()[data.status()];
        step.setSequence(data.sequence());
        step.setObjective(data.objective());
        step.setDescription(data.description());
        step.setRequirements(data.requirements());
        step.setStatus(status);
        step.setCompletedAt(status == Status.Finished ? Timestamp.from(Instant.now()) : null);
        return stepMapper.toStepDTO(step);
    }

    @Transactional
    public void delete(long stepId) {
        final long goalId = stepRepo.findGoalIdById(stepId);
        final List<Step> steps = stepRepo.findAllByGoalId(goalId);

        steps.removeIf(step1 -> step1.getId().equals(stepId));
        stepRepo.deleteById(stepId);

        steps.sort(Comparator.comparingInt(Step::getSequence));
        for (int i = 0; i < steps.size(); i++) {
            steps.get(i).setSequence(i + 1);
        }
        stepRepo.saveAll(steps);
    }

}
