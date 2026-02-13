package be.osse.focus_track_api.service.projects.step;

import be.osse.focus_track_api.domain.projects.Goal;
import be.osse.focus_track_api.domain.projects.Step;
import be.osse.focus_track_api.domain.projects.dto.CreateStepDTO;
import be.osse.focus_track_api.domain.projects.dto.StepDTO;
import be.osse.focus_track_api.domain.projects.dto.UpdateStepDTO;
import be.osse.focus_track_api.repository.projects.GoalRepo;
import be.osse.focus_track_api.repository.projects.StepRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StepServiceTest {
    @Mock
    private StepRepo stepRepo;
    @Mock
    private StepMapper stepMapper;
    @Mock
    private GoalRepo goalRepo;

    private StepService stepService;

    @BeforeEach
    public void setUp() {
        stepService = new StepService(stepRepo, stepMapper, goalRepo);
    }

    @Test
    public void testExistsById() {
        // GIVEN
        final long stepId = 1L;
        when(stepRepo.existsById(stepId)).thenReturn(true);

        // WHEN
        final boolean result = stepService.existsById(stepId);

        // THEN
        assertTrue(result);
    }

    @Test
    public void testExistsByIdAndSequence() {
        // GIVEN
        final long stepId = 1L;
        final int sequence = 1;
        when(stepRepo.existsByIdAndSequence(stepId, sequence)).thenReturn(true);

        // WHEN
        final boolean result = stepService.existsByIdAndSequence(stepId, sequence);

        // THEN
        assertTrue(result);
    }

    @Test
    public void testGetGoalIdById() {
        // GIVEN
        final long stepId = 1L;
        final long goalId = 2L;
        when(stepRepo.findGoalIdById(stepId)).thenReturn(goalId);

        // WHEN
        final long result = stepService.getGoalIdById(stepId);

        // THEN
        assertEquals(goalId, result);
    }

    @Test
    public void testGetMaxSequenceForGoal() {
        // GIVEN
        final long stepId = 1L;
        final int maxSequence = 4;
        when(stepRepo.findMaxSequenceForGoal(stepId)).thenReturn(maxSequence);

        // WHEN
        final int result = stepService.getMaxSequenceForGoal(stepId);

        // THEN
        assertEquals(maxSequence, result);
    }

    @Test
    public void testGetAll() {
        // GIVEN
        final long goalId = 1L;
        final List<Step> steps = List.of(mock(Step.class));
        when(stepRepo.findAllByGoalId(goalId)).thenReturn(steps);
        when(stepMapper.toStepDTO(any(Step.class))).thenReturn(mock(StepDTO.class));

        // WHEN
        final List<StepDTO> result = stepService.getAll(goalId);

        // THEN
        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    public void testSave() {
        // GIVEN
        final CreateStepDTO data = mock(CreateStepDTO.class);
        final long goalId = 1L;
        final Goal goal = mock(Goal.class);
        final Step newStep = mock(Step.class);
        final Step savedStep = mock(Step.class);
        final StepDTO expected = mock(StepDTO.class);

        when(data.goalId()).thenReturn(goalId);
        when(goalRepo.findById(goalId)).thenReturn(Optional.of(goal));
        when(stepMapper.toStep(data, goal)).thenReturn(newStep);
        when(stepRepo.save(newStep)).thenReturn(savedStep);
        when(stepMapper.toStepDTO(savedStep)).thenReturn(expected);

        // WHEN
        final StepDTO result = stepService.save(data);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    public void testUpdate() {
        // GIVEN
        final UpdateStepDTO data = mock(UpdateStepDTO.class);
        final long stepId = 1L;
        final Step step = mock(Step.class);
        final StepDTO expected = mock(StepDTO.class);

        when(data.id()).thenReturn(stepId);
        when(stepRepo.findById(stepId)).thenReturn(Optional.of(step));
        when(stepMapper.toStepDTO(step)).thenReturn(expected);

        // WHEN
        final StepDTO result = stepService.update(data);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    public void testDelete() {
        // GIVEN
        final long stepId = 3L;
        final long goalId = 1L;

        final Step step1 = mock(Step.class);
        final Step step2 = mock(Step.class);
        final Step step3 = mock(Step.class);

        when(step1.getId()).thenReturn(2L);
        when(step2.getId()).thenReturn(3L);
        when(step3.getId()).thenReturn(4L);

        final List<Step> steps = new ArrayList<>(List.of(step1, step2, step3));

        when(stepRepo.findGoalIdById(stepId)).thenReturn(goalId);
        when(stepRepo.findAllByGoalId(goalId)).thenReturn(steps);

        // WHEN
        stepService.delete(stepId);

        // THEN
        verify(stepRepo).deleteById(stepId);
        verify(stepRepo).saveAll(steps);
        assertEquals(2, steps.size());
    }


}
