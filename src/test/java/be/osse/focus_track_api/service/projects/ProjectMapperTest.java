package be.osse.focus_track_api.service.projects;

import be.osse.focus_track_api.domain.general.AppUser;
import be.osse.focus_track_api.domain.logging.Log;
import be.osse.focus_track_api.domain.projects.Project;
import be.osse.focus_track_api.dto.projects.CreateProjectDTO;
import be.osse.focus_track_api.dto.projects.ProjectDTO;
import be.osse.focus_track_api.service.projects.project.ProjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

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
    void testToProjectDTO() {
        // GIVEN
        AppUser appUser = mock(AppUser.class);
        Project project = mock(Project.class);

        when(project.getId()).thenReturn(420L);
        when(project.getTitle()).thenReturn("Test Project");
        when(project.getDescription()).thenReturn("Test Project");
        when(project.isArchived()).thenReturn(false);

        // WHEN
        ProjectDTO projectDTO = projectMapper.toProjectDTO(project);

        // THEN
        assertEquals(420L, projectDTO.id());
        assertEquals(project.getTitle(), projectDTO.title());
        assertEquals(project.getDescription(), projectDTO.description());
        assertEquals(project.isArchived(), projectDTO.archived());
    }

    @Test
    void testToProject() {
        // GIVEN
        CreateProjectDTO createProjectDTO = new CreateProjectDTO("name", "desc", false);
        AppUser appUser = mock(AppUser.class);

        // WHEN
        Project result = projectMapper.toProject(createProjectDTO, appUser);

        // THEN
        assertEquals(createProjectDTO.title(), result.getTitle());
        assertEquals(createProjectDTO.description(), result.getDescription());
        assertEquals(appUser, result.getUser());
        assertNotNull(result.getLog());
        assertFalse(result.isArchived());
        assertNull(result.getId());
    }
}
