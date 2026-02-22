package be.osse.focus_track_api.service.projects.goal;

import be.osse.focus_track_api.domain.predefined.Priority;
import be.osse.focus_track_api.domain.projects.Goal;
import be.osse.focus_track_api.domain.projects.Project;
import be.osse.focus_track_api.domain.projects.dto.CreateGoalDTO;
import be.osse.focus_track_api.domain.projects.dto.GoalDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GoalMapperTest {

    private GoalMapper goalMapper;

    @BeforeEach
    void setUp() {
        goalMapper = new GoalMapper();
    }

    @Test
    public void testToGoalDTO() {
        // GIVEN
        final Goal goal = mock(Goal.class);

        when(goal.getId()).thenReturn(1L);
        when(goal.getTitle()).thenReturn("goal title");
        when(goal.getDescription()).thenReturn("goal description");
        when(goal.getPriority()).thenReturn(Priority.LOW);
        when(goal.getEstimated()).thenReturn(540L);

        // WHEN
        final GoalDTO goalDTO = goalMapper.toGoalDTO(goal);

        // THEN
        assertEquals(1L, goalDTO.id());
        assertEquals("goal title", goalDTO.title());
        assertEquals("goal description", goalDTO.description());
        assertEquals(Priority.LOW.ordinal(), goalDTO.priority());
        assertEquals(540L, goalDTO.estimated());
    }

    @Test
    public void testToGoal() {
        // GIVEN
        final Project project = mock(Project.class);
        final CreateGoalDTO data = new CreateGoalDTO(1L, "title", "description", Priority.LOW, 540L);

        // WHEN
        final Goal result = goalMapper.toGoal(project, data);

        // THEN
        assertEquals(project, result.getProject());
        assertEquals("title", result.getTitle());
        assertEquals("description", result.getDescription());
        assertEquals(Priority.LOW, result.getPriority());
        assertEquals(540L, result.getEstimated());
    }
}
