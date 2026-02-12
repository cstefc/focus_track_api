package be.osse.focus_track_api.service.projects.goal;

import be.osse.focus_track_api.domain.predefined.Priority;
import be.osse.focus_track_api.domain.projects.Goal;
import be.osse.focus_track_api.domain.projects.Project;
import be.osse.focus_track_api.domain.projects.dto.CreateGoalDTO;
import be.osse.focus_track_api.domain.projects.dto.GoalDTO;
import be.osse.focus_track_api.domain.projects.dto.UpdateGoalDTO;
import be.osse.focus_track_api.repository.projects.GoalRepo;
import be.osse.focus_track_api.repository.projects.ProjectRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GoalServiceTest {

    @Mock
    private GoalMapper goalMapper;

    @Mock
    private GoalRepo goalRepo;

    @Mock
    private ProjectRepo projectRepo;

    private GoalService goalService;

    @BeforeEach
    void setUp() {
        goalService = new GoalService(goalRepo, goalMapper, projectRepo);
    }

    @Test
    public void testGetAll() {
        // GIVEN
        final long projectId = 1L;
        when(goalRepo.findAllByProjectId(projectId)).thenReturn(List.of(mock(Goal.class)));
        when(goalMapper.toGoalDTO(any(Goal.class))).thenReturn(mock(GoalDTO.class));

        // WHEN
        final List<GoalDTO> result = goalService.getAll(projectId);

        // THEN
        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    public void testExists(){
        // GIVEN
        final long goalId = 1L;
        when(goalRepo.existsById(goalId)).thenReturn(true);

        // WHEN
        final boolean result = goalService.exists(goalId);

        // THEN
        assertTrue(result);
    }

    @Test
    public void testGetParentId() {
        // GIVEN
        final long projectId = 1L;
        final long goalId = 2L;

        when(goalRepo.findProjectIdById(goalId)).thenReturn(projectId);

        // WHEN
        final long result = goalService.getParentId(goalId);

        // THEN
        assertEquals(projectId, result);
    }

    @Test
    public void testCreate() {
        // GIVEN
        final long projectId = 1L;
        final CreateGoalDTO data = mock(CreateGoalDTO.class);

        final Project project = mock(Project.class);
        final Goal new_goal = mock(Goal.class);
        final Goal saved_goal = mock(Goal.class);
        final GoalDTO expected = mock(GoalDTO.class);

        when(projectRepo.findById(projectId)).thenReturn(Optional.of(project));
        when(goalMapper.toGoal(project, data)).thenReturn(new_goal);
        when(goalRepo.save(new_goal)).thenReturn(saved_goal);
        when(goalMapper.toGoalDTO(saved_goal)).thenReturn(expected);

        // WHEN
        final GoalDTO result = goalService.create(projectId, data);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    public void testUpdate() {
        // GIVEN
        final UpdateGoalDTO data = mock(UpdateGoalDTO.class);
        final Goal goal = mock(Goal.class);
        final GoalDTO expected = mock(GoalDTO.class);

        when(data.id()).thenReturn(1L);
        when(data.title()).thenReturn("title");
        when(data.description()).thenReturn("description");
        when(data.priority()).thenReturn(Priority.Low);
        when(data.estimated()).thenReturn(null);

        when(goalRepo.findById(1L)).thenReturn(Optional.of(goal));
        when(goalMapper.toGoalDTO(goal)).thenReturn(expected);

        // WHEN
        final GoalDTO result = goalService.update(data);

        // THEN
        assertEquals(expected, result);
        verify(goal).setTitle("title");
        verify(goal).setDescription("description");
        verify(goal).setPriority(Priority.Low);
        verify(goal).setEstimated(null);
    }

    @Test
    public void testDelete() {
        // GIVEN
        final long goalId = 1L;

        // WHEN
        goalService.delete(goalId);

        // THEN
        verify(goalRepo).deleteById(goalId);
    }


}
