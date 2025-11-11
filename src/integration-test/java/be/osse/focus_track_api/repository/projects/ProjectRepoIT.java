package be.osse.focus_track_api.repository.projects;


import be.osse.focus_track_api.domain.general.AppUser;
import be.osse.focus_track_api.domain.projects.Project;
import be.osse.focus_track_api.repository.general.AppUserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
class ProjectRepoIT {

    @Autowired
    private ProjectRepo repo;

    @Autowired
    private AppUserRepo appUserRepo;

    @Test
    void testFindByAppUserUuid() {
        // GIVEN
        AppUser user = new AppUser("test-uuid", "test", "test@email.com", List.of());
        appUserRepo.save(user);

        Project project = new Project();
        project.setUser(user);
        project.setName("Test Project");
        project.setDescription("Test Project Description");
        project.setArchived(false);
        project.setGoals(List.of());
        project.setLog(null);

        repo.save(project);

        // WHEN
        List<Project> expected = repo.findByAppUserUuid("test-uuid");

        // THEN
        assertNotNull(expected);
        assertEquals(1, expected.size());
        assertEquals(project, expected.getFirst());
    }
}
