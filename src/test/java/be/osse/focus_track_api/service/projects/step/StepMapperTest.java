package be.osse.focus_track_api.service.projects.step;

import be.osse.focus_track_api.domain.predefined.Status;
import be.osse.focus_track_api.domain.projects.Goal;
import be.osse.focus_track_api.domain.projects.Step;
import be.osse.focus_track_api.domain.projects.dto.CreateStepDTO;
import be.osse.focus_track_api.domain.projects.dto.StepDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StepMapperTest {


    public StepMapper stepMapper;

    @BeforeEach
    public void setUp() {
        stepMapper = new StepMapper();
    }

    @Test
    public void testToStepDTO() {
        // GIVEN
        final Step step = mock(Step.class);
        when(step.getId()).thenReturn(1L);
        when(step.getSequence()).thenReturn(1);
        when(step.getDescription()).thenReturn("Description");
        when(step.getObjective()).thenReturn("Objective");
        when(step.getRequirements()).thenReturn("Requirements");
        when(step.getStatus()).thenReturn(Status.Finished);

        // WHEN
        final StepDTO result = stepMapper.toStepDTO(step);

        // THEN
        assertEquals(1L, result.id());
        assertEquals(1, result.sequence());
        assertEquals("Description", result.description());
        assertEquals("Objective", result.objective());
        assertEquals("Requirements", result.requirements());
        assertEquals(Status.Finished.ordinal(), result.status());
    }

    @Test
    public void testToStep() {
        // GIVEN
        final CreateStepDTO data = new CreateStepDTO(1L, 1, "Objective", "Description",
                "Requirements", Status.NotStarted.ordinal());
        final Goal goal = mock(Goal.class);

        // WHEN
        final Step result = stepMapper.toStep(data, goal);

        // THEN
        assertEquals(1, result.getSequence());
        assertEquals("Objective", result.getObjective());
        assertEquals("Description", result.getDescription());
        assertEquals("Requirements", result.getRequirements());
        assertEquals(Status.NotStarted, result.getStatus());
        assertEquals(goal, result.getGoal());
    }

}
