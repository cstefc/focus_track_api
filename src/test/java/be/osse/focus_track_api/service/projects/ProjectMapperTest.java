package be.osse.focus_track_api.service.projects;

import be.osse.focus_track_api.domain.general.AppUser;
import be.osse.focus_track_api.domain.logging.Log;
import be.osse.focus_track_api.domain.projects.Project;
import be.osse.focus_track_api.dto.projects.CreateProjectDTO;
import be.osse.focus_track_api.dto.projects.GetProjectDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProjectMapperTest {
    private ProjectMapper projectMapper;

    @BeforeEach
    void setUp() {
        projectMapper = new ProjectMapper();
    }

    @Test
    void testToGetProjectDTO() {
        // GIVEN
        AppUser appUser = mock(AppUser.class);
        Project project = mock(Project.class);

        when(project.getId()).thenReturn(420L);
        when(project.getTitle()).thenReturn("Test Project");
        when(project.getDescription()).thenReturn("Test Project");
        when(project.isArchived()).thenReturn(false);

        when(appUser.getUuid()).thenReturn(UUID.randomUUID().toString());
        when(project.getUser()).thenReturn(appUser);


        // WHEN
        GetProjectDTO getProjectDTO = projectMapper.toGetProjectDTO(project);

        // THEN
        assertEquals(420L, getProjectDTO.id());
        assertEquals(project.getTitle(), getProjectDTO.title());
        assertEquals(project.getDescription(), getProjectDTO.description());
        assertEquals(project.isArchived(), getProjectDTO.archived());
    }

    @Test
    void testToProject() {
        // GIVEN
        CreateProjectDTO createProjectDTO = new CreateProjectDTO("name", "desc");
        AppUser appUser = mock(AppUser.class);
        Log log = mock(Log.class);

        // WHEN
        Project result = projectMapper.toProject(createProjectDTO, appUser, log);

        // THEN
        assertEquals(createProjectDTO.name(), result.getTitle());
        assertEquals(createProjectDTO.description(), result.getDescription());
        assertEquals(appUser, result.getUser());
        assertEquals(log, result.getLog());
        assertFalse(result.isArchived());
        assertNull(result.getId());
    }
}
