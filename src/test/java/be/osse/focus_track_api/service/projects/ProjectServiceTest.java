package be.osse.focus_track_api.service.projects;

import be.osse.focus_track_api.domain.general.AppUser;
import be.osse.focus_track_api.domain.projects.Project;
import be.osse.focus_track_api.repository.projects.ProjectRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProjectServiceTest {

    @Mock
    ProjectRepo projectRepo;

    private ProjectService projectService;

    @BeforeEach
    void setUp() {
        projectService = new ProjectService(projectRepo);
    }

    @Test
    void testFindByAppUserUuid() {
        // GIVEN
        String uuid = UUID.randomUUID().toString();
        AppUser appUser = mock(AppUser.class);
        List<Project> projects = List.of(mock(Project.class));

        when(appUser.getUuid()).thenReturn(uuid);
        when(projectRepo.findByAppUserUuid(uuid)).thenReturn(projects);

        // WHEN
        List<Project> results = projectService.findAllByUser(appUser);

        // THEN
        assertEquals(projects, results);
    }

    @Test
    void testSave() {
        // GIVEN
        Project project = mock(Project.class);
        Project saved = mock(Project.class);
        when(projectRepo.save(project)).thenReturn(saved);

        // WHEN
        Project result = projectService.save(project);

        // THEN
        assertEquals(saved, result);
    }
}
