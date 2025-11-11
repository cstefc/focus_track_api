package be.osse.focus_track_api.controller.general;


import be.osse.focus_track_api.domain.general.AppUser;
import be.osse.focus_track_api.repository.general.AppUserRepo;
import jakarta.validation.constraints.AssertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
class AppUserControllerIT {

    @Autowired
    private AppUserRepo repo;

    @Test
    void testSave() {
        // GIVEN
        AppUser user = new AppUser();
        user.setName("test");
        user.setEmail("test@email.com");

        // WHEN
        repo.save(user);

        // THEN
        AppUser expected = repo.save(user);

        assertNotNull(expected);
        assertNotNull(expected.getUuid());
    }
}
