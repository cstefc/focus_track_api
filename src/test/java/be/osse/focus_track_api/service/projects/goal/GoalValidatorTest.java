package be.osse.focus_track_api.service.projects.goal;

import be.osse.focus_track_api.domain.predefined.Priority;
import be.osse.focus_track_api.domain.projects.dto.CreateGoalDTO;
import be.osse.focus_track_api.domain.projects.dto.UpdateGoalDTO;
import be.osse.focus_track_api.service.projects.project.ProjectValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GoalValidatorTest {

    @Mock
    public ProjectValidator projectValidator;

    @Mock
    public GoalService goalService;

    public GoalValidator goalValidator;

    @BeforeEach
    public void setUp() {
        goalValidator = new GoalValidator(goalService, projectValidator);
    }

    @Test
    public void testValidateCreateData_full(){
        // GIVEN
        final CreateGoalDTO data = new CreateGoalDTO(1L, "title", "description", Priority.Low, LocalTime.of(1, 30));

        // WHEN
        final boolean result = goalValidator.validateCreateData(data);

        // THEN
        assertTrue(result);
    }

    @Test
    public void testValidateCreateData_no_title(){
        // GIVEN
        final CreateGoalDTO data = new CreateGoalDTO(1L, "", "description", Priority.Low, LocalTime.of(1, 30));

        // WHEN
        final boolean result = goalValidator.validateCreateData(data);

        // THEN
        assertFalse(result);
    }

    @Test
    public void testValidateCreateData_minimal(){
        // GIVEN
        final CreateGoalDTO data = new CreateGoalDTO(1L, "title", null, null, null);

        // WHEN
        final boolean result = goalValidator.validateCreateData(data);

        // THEN
        assertTrue(result);
    }

    @Test
    public void testValidateUpdateData_valid_goalId(){
        // GIVEN
        final UpdateGoalDTO data = new UpdateGoalDTO(1L, "title", "description", Priority.Low, LocalTime.of(1, 30));
        when(goalService.exists(1L)).thenReturn(true);

        // WHEN
        final boolean result = goalValidator.validateUpdateData(data);

        // THEN
        assertTrue(result);
    }

    @Test
    public void testValidateUpdateData_invalid_goalId(){
        // GIVEN
        final UpdateGoalDTO data = new UpdateGoalDTO(1L, "title", "description", Priority.Low, LocalTime.of(1, 30));
        when(goalService.exists(1L)).thenReturn(false);

        // WHEN
        final boolean result = goalValidator.validateUpdateData(data);

        // THEN
        assertFalse(result);
    }

    @Test
    public void testValidateUpdateData_no_title(){
        // GIVEN
        final UpdateGoalDTO data = new UpdateGoalDTO(1L, "", "description", Priority.Low, LocalTime.of(1, 30));
        when(goalService.exists(1L)).thenReturn(true);

        // WHEN
        final boolean result = goalValidator.validateUpdateData(data);

        // THEN
        assertFalse(result);
    }

    @Test
    public void testValidateUpdateData_minimal(){
        // GIVEN
        final UpdateGoalDTO data = new UpdateGoalDTO(1L, "title", null, null, null);
        when(goalService.exists(1L)).thenReturn(true);

        // WHEN
        final boolean result = goalValidator.validateUpdateData(data);

        // THEN
        assertTrue(result);
    }

    @Test
    public void testValidateGoalAccess_success(){
        // GIVEN
        final long goalId = 1L;
        final String uuid = "dev-001";

        when(goalService.exists(goalId)).thenReturn(true);
        when(goalService.getParentId(goalId)).thenReturn(2L);
        when(projectValidator.validateProjectAccess(uuid, 2L)).thenReturn(true);

        // WHEN
        final boolean result = goalValidator.validateGoalAccess(uuid, goalId);

        // THEN
        assertTrue(result);
    }

    @Test
    public void testValidateGoalAccess_wrong_goalId(){
        // GIVEN
        final long goalId = 1L;
        final String uuid = "dev-001";

        when(goalService.exists(goalId)).thenReturn(false);

        // WHEN
        final boolean result = goalValidator.validateGoalAccess(uuid, goalId);

        // THEN
        assertFalse(result);
    }

    @Test
    public void testValidateGoalAccess_not_owner(){
        // GIVEN
        final long goalId = 1L;
        final String uuid = "dev-001";

        when(goalService.exists(goalId)).thenReturn(true);
        when(goalService.getParentId(goalId)).thenReturn(2L);
        when(projectValidator.validateProjectAccess(uuid, 2L)).thenReturn(false);

        // WHEN
        final boolean result = goalValidator.validateGoalAccess(uuid, goalId);

        // THEN
        assertFalse(result);
    }
}
