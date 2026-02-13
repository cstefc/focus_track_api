package be.osse.focus_track_api.service.projects.step;

import be.osse.focus_track_api.domain.predefined.Status;
import be.osse.focus_track_api.domain.projects.dto.CreateStepDTO;
import be.osse.focus_track_api.domain.projects.dto.UpdateStepDTO;
import be.osse.focus_track_api.service.projects.goal.GoalValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StepValidatorTest {

    @Mock
    private StepService stepService;

    @Mock
    private GoalValidator goalValidator;

    private StepValidator stepValidator;

    @BeforeEach
    public void setUp(){
        stepValidator = new StepValidator(goalValidator, stepService);
    }

    @Test
    public void testValidateCreateData_full() {
        // GIVEN
        final CreateStepDTO data = new CreateStepDTO(1L, 3,
                "Objective", "Description", "Requirements", Status.NotStarted.ordinal());

        when(stepService.getMaxSequenceForGoal(1L)).thenReturn(2);

        // WHEN
        final boolean result = stepValidator.validateCreateData(data);

        // THEN
        assertTrue(result);
    }

    @Test
    public void testValidateCreateData_no_objective() {
        // GIVEN
        final CreateStepDTO data = new CreateStepDTO(1L, 3,
                "", "Description", "Requirements", Status.NotStarted.ordinal());

        when(stepService.getMaxSequenceForGoal(1L)).thenReturn(2);

        // WHEN
        final boolean result = stepValidator.validateCreateData(data);

        // THEN
        assertFalse(result);
    }

    @Test
    public void testValidateCreateData_minimal() {
        // GIVEN
        final CreateStepDTO data = new CreateStepDTO(1L, 3,
                "Objective", "", "", Status.NotStarted.ordinal());

        when(stepService.getMaxSequenceForGoal(1L)).thenReturn(2);

        // WHEN
        final boolean result = stepValidator.validateCreateData(data);

        // THEN
        assertTrue(result);
    }

    @Test
    public void testValidateUpdateData_full() {
        // GIVEN
        final UpdateStepDTO data = new UpdateStepDTO(1L, 2,
                "Objective", "Description", "Requirements", Status.NotStarted.ordinal(), null);

        when(stepService.existsById(1L)).thenReturn(true);
        when(stepService.existsByIdAndSequence(1L, 2)).thenReturn(true);

        // WHEN
        final boolean result = stepValidator.validateUpdateData(data);

        // THEN
        assertTrue(result);
    }

    @Test
    public void testValidateUpdateData_invalid_id() {
        // GIVEN
        final UpdateStepDTO data = new UpdateStepDTO(1L, 2,
                "Objective", "Description", "Requirements", Status.NotStarted.ordinal(), null);

        when(stepService.existsById(1L)).thenReturn(false);

        // WHEN
        final boolean result = stepValidator.validateUpdateData(data);

        // THEN
        assertFalse(result);
    }

    @Test
    public void testValidateUpdateData_invalid_id_sequence_combination() {
        // GIVEN
        final UpdateStepDTO data = new UpdateStepDTO(1L, 2,
                "Objective", "Description", "Requirements", Status.NotStarted.ordinal(), null);

        when(stepService.existsById(1L)).thenReturn(true);
        when(stepService.existsByIdAndSequence(1L, 2)).thenReturn(false);

        // WHEN
        final boolean result = stepValidator.validateUpdateData(data);

        // THEN
        assertFalse(result);
    }

    @Test
    public void testValidateUpdateData_no_objective() {
        // GIVEN
        final UpdateStepDTO data = new UpdateStepDTO(1L, 2,
                "", "Description", "Requirements", Status.NotStarted.ordinal(), null);

        when(stepService.existsById(1L)).thenReturn(true);
        when(stepService.existsByIdAndSequence(1L, 2)).thenReturn(true);

        // WHEN
        final boolean result = stepValidator.validateUpdateData(data);

        // THEN
        assertFalse(result);
    }

    @Test
    public void testValidateUpdateData_minimal() {
        // GIVEN
        final UpdateStepDTO data = new UpdateStepDTO(1L, 2,
                "Objective", null, null, Status.NotStarted.ordinal(), null);

        when(stepService.existsById(1L)).thenReturn(true);
        when(stepService.existsByIdAndSequence(1L, 2)).thenReturn(true);

        // WHEN
        final boolean result = stepValidator.validateUpdateData(data);

        // THEN
        assertTrue(result);
    }

    @Test
    public void testValidateStepAccess_valid() {
        // GIVEN
        final String uuid = "dev-001";
        final long stepId = 1L;

        when(stepService.existsById(stepId)).thenReturn(true);
        when(stepService.getGoalIdById(stepId)).thenReturn(2L);
        when(goalValidator.validateGoalAccess(uuid, 2L)).thenReturn(true);

        // WHEN
        final boolean result = stepValidator.validateStepAccess(uuid, stepId);

        // THEN
        assertTrue(result);
    }

    @Test
    public void testValidateStepAccess_no_goalAccess() {
        // GIVEN
        final String uuid = "dev-001";
        final long stepId = 1L;

        when(stepService.existsById(stepId)).thenReturn(true);
        when(stepService.getGoalIdById(stepId)).thenReturn(2L);
        when(goalValidator.validateGoalAccess(uuid, 2L)).thenReturn(false);

        // WHEN
        final boolean result = stepValidator.validateStepAccess(uuid, stepId);

        // THEN
        assertFalse(result);
    }

}
