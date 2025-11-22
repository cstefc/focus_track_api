package be.osse.focus_track_api.service.projects;

import be.osse.focus_track_api.domain.projects.Project;
import be.osse.focus_track_api.dto.projects.CreateProjectDTO;
import be.osse.focus_track_api.dto.projects.ProjectDTO;
import be.osse.focus_track_api.repository.projects.ProjectRepo;
import be.osse.focus_track_api.service.general.AppUserService;
import be.osse.focus_track_api.service.projects.project.ProjectMapper;
import be.osse.focus_track_api.service.projects.project.ProjectService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
    void testSave() {
        // GIVEN
        String uuid = UUID.randomUUID().toString();
        CreateProjectDTO project = mock(CreateProjectDTO.class);
        Project saved = mock(Project.class);
        when(projectRepo.save(project)).thenReturn(saved);

        // WHEN
        Project result = projectService.create(uuid, project);

        // THEN
        verify(projectRepo).save(project);
        assertEquals(saved, result);
    }
}
