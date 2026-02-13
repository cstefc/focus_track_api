package be.osse.focus_track_api.service.projects.project;

import be.osse.focus_track_api.domain.projects.dto.CreateProjectDTO;
import be.osse.focus_track_api.domain.projects.dto.UpdateProjectDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProjectValidatorTest {

    @Mock
    ProjectService projectService;

    private ProjectValidator projectValidator;

    @BeforeEach
    void setUp() {
        projectValidator = new ProjectValidator(projectService);
    }

    @Test
    void testValidateCreateData_full() {
        // GIVEN
        final CreateProjectDTO data = new CreateProjectDTO("title ok", "description", false);

        // WHEN
        final boolean result = projectValidator.validateCreateData(data);

        // THEN
        assertTrue(result);
    }

    @Test
    void testValidateCreateData_no_title() {
        // GIVEN
        final CreateProjectDTO data = new CreateProjectDTO(null, null, false);

        // WHEN
        final boolean result = projectValidator.validateCreateData(data);

        // THEN
        assertFalse(result);
    }

    @Test
    void testValidateCreateData_no_description() {
        // GIVEN
        final CreateProjectDTO data = new CreateProjectDTO("Hello", null, false);

        // WHEN
        final boolean result = projectValidator.validateCreateData(data);

        // THEN
        assertTrue(result);
    }

    @Test
    void testValidateUpdateData_full() {
        // GIVEN
        final long projectId = 14;
        final UpdateProjectDTO data = new UpdateProjectDTO(projectId, "title", "description", false);
        when(projectService.exists(projectId)).thenReturn(true);
        when(projectService.getAppUserUuidById(projectId)).thenReturn("dev-001");

        // WHEN
        final boolean result = projectValidator.validateUpdateData("dev-001", data);

        // THEN
        assertTrue(result);
    }

    @Test
    void testValidateUpdateData_invalid_projectId() {
        // GIVEN
        final long projectId = 14;
        final UpdateProjectDTO data = new UpdateProjectDTO(projectId, "title", "description", false);
        when(projectService.exists(projectId)).thenReturn(false);

        // WHEN
        final boolean result = projectValidator.validateUpdateData("dev-001", data);

        // THEN
        assertFalse(result);
    }

    @Test
    void testValidateUpdateData_no_title() {
        // GIVEN
        final long projectId = 14;
        final UpdateProjectDTO data = new UpdateProjectDTO(projectId, null, "description", false);
        when(projectService.exists(projectId)).thenReturn(true);

        // WHEN
        final boolean result = projectValidator.validateUpdateData("dev-001", data);

        // THEN
        assertFalse(result);
    }

    @Test
    void testValidateUpdateData_no_description() {
        // GIVEN
        final long projectId = 14;
        final UpdateProjectDTO data = new UpdateProjectDTO(projectId, "title", null, false);
        when(projectService.exists(projectId)).thenReturn(true);
        when(projectService.getAppUserUuidById(projectId)).thenReturn("dev-001");

        // WHEN
        final boolean result = projectValidator.validateUpdateData("dev-001", data);

        // THEN
        assertTrue(result);
    }

    @Test
    void testValidateProjectAccess_success() {
        // GIVEN
        final long projectId = 1;
        when(projectService.exists(projectId)).thenReturn(true);
        when(projectService.getAppUserUuidById(1)).thenReturn("dev-001");

        // WHEN
        final boolean result = projectValidator.validateProjectAccess("dev-001", projectId);

        // THEN
        assertTrue(result);
    }

    @Test
    void testValidateProjectAccess_invalid_projectId() {
        // GIVEN
        final long projectId = 1;
        when(projectService.exists(projectId)).thenReturn(false);
        when(projectService.getAppUserUuidById(1)).thenReturn("dev-001");

        // WHEN
        final boolean result = projectValidator.validateProjectAccess("dev-001", projectId);

        // THEN
        assertFalse(result);
    }

    @Test
    void testValidateProjectAccess_not_project_owner() {
        // GIVEN
        final long projectId = 1;
        when(projectService.exists(projectId)).thenReturn(true);
        when(projectService.getAppUserUuidById(1)).thenReturn("dev-002");

        // WHEN
        final boolean result = projectValidator.validateProjectAccess("dev-001", projectId);

        // THEN
        assertFalse(result);
    }


}
