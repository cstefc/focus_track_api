package be.osse.focus_track_api.repository.projects;


import be.osse.focus_track_api.domain.projects.Project;
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

    @Test
    void testFindByAppUserUuid() {
        // GIVEN

        // WHEN
        List<Project> expected = repo.findByAppUserUuid("dev-001");

        // THEN
        assertNotNull(expected);
        assertEquals(3, expected.size());
    }
}
