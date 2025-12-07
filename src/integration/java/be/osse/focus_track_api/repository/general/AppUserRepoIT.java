package be.osse.focus_track_api.repository.general;


import be.osse.focus_track_api.domain.general.AppUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("it")
class AppUserRepoIT {

    @Autowired
    private AppUserRepo repo;

    @Test
    void testSave() {
        // GIVEN
        AppUser user = new AppUser("test-uuid", "test", "test@email.com", List.of());
        repo.save(user);

        // WHEN
        AppUser expected = repo.findByUuid("test-uuid");

        // THEN
        assertNotNull(expected);
        assertNotNull(expected.getUuid());
    }
}
