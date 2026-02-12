package be.osse.focus_track_api.service.projects.project;

import be.osse.focus_track_api.domain.projects.Project;
import be.osse.focus_track_api.domain.projects.dto.CreateProjectDTO;
import be.osse.focus_track_api.domain.projects.dto.ProjectDTO;
import be.osse.focus_track_api.domain.projects.dto.UpdateProjectDTO;
import be.osse.focus_track_api.repository.projects.ProjectRepo;
import be.osse.focus_track_api.service.general.AppUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProjectServiceTest {

    @Mock
    ProjectRepo projectRepo;

    @Mock
    ProjectMapper projectMapper;

    @Mock
    AppUserService appUserService;

    private ProjectService projectService;

    @BeforeEach
    void setUp() {
        projectService = new ProjectService(projectRepo, projectMapper, appUserService);
    }

    @Test
    void testExists(){
        // GIVEN
        final long projectId = 1;
        when(projectRepo.existsById(projectId)).thenReturn(true);

        // WHEN
        final boolean result = projectService.exists(1);

        // THEN
        assertTrue(result);
    }

    @Test()
    void testGetByIdNull(){
        // GIVEN
        final long projectId = 1;
        when(projectRepo.findById(projectId)).thenReturn(Optional.empty());

        // WHEN / THEN
        assertThrows(NoSuchElementException.class, () -> projectService.getById(projectId));
    }

    @Test
    void testFindByAppUserUuid() {
        // GIVEN
        String uuid = UUID.randomUUID().toString();
        List<Project> projects = List.of(mock(Project.class));

        when(projectRepo.findByAppUserUuid(uuid)).thenReturn(projects);
        when(projectMapper.toProjectDTO(any())).thenReturn(mock(ProjectDTO.class));

        // WHEN
        List<ProjectDTO> results = projectService.findAllByUser(uuid);

        // THEN
        verify(projectRepo).findByAppUserUuid(uuid);
        assertEquals(projects.size(), results.size());
    }

    @Test
    void testCreate() {
        // GIVEN
        String uuid = "dev-001";
        CreateProjectDTO project = mock(CreateProjectDTO.class);
        ProjectDTO saved = mock(ProjectDTO.class);

        when(projectRepo.save(any())).thenReturn(mock(Project.class));
        when(projectMapper.toProjectDTO(any())).thenReturn(saved);

        // WHEN
        ProjectDTO result = projectService.create(uuid, project);

        // THEN
        assertEquals(saved, result);
    }

    @Test
    void testUpdate(){
        // GIVEN
        final UpdateProjectDTO data = mock(UpdateProjectDTO.class);
        final Project project = mock(Project.class);
        final ProjectDTO expected = mock(ProjectDTO.class);

        when(data.id()).thenReturn(1L);
        when(projectRepo.findById(1L)).thenReturn(Optional.of(project));
        when(projectMapper.toProjectDTO(project)).thenReturn(expected);

        // WHEN
        final ProjectDTO result = projectService.update(data);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testDelete(){
        // GIVEN
        final long projectId = 1L;

        // WHEN
        projectService.delete(projectId);

        // THEN
        verify(projectRepo).deleteById(projectId);

    }
}
