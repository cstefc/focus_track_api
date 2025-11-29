package be.osse.focus_track_api.service.projects.step;

import be.osse.focus_track_api.domain.predefined.Status;
import be.osse.focus_track_api.domain.projects.Goal;
import be.osse.focus_track_api.domain.projects.Step;
import be.osse.focus_track_api.dto.projects.CreateStepDTO;
import be.osse.focus_track_api.dto.projects.StepDTO;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;

@Service
public class StepMapper {

    public StepDTO toStepDTO(Step step) {
        return new StepDTO(
                step.getId(),
                step.getSequence(),
                step.getObjective(),
                step.getDescription(),
                step.getRequirements(),
                step.getStatus().ordinal());
    }

    public Step toStep(CreateStepDTO stepDTO, Goal goal) {
        final Step step = new Step();
        final Status status = Status.values()[stepDTO.status()];
        step.setSequence(stepDTO.sequence());
        step.setObjective(stepDTO.objective());
        step.setDescription(stepDTO.description());
        step.setRequirements(stepDTO.requirements());
        step.setStatus(status);
        step.setCompletedAt(status == Status.Finished ? Timestamp.from(Instant.now()) : null);
        step.setGoal(goal);
        return step;
    }
}
