package be.osse.focus_track_api.repository.general;

import be.osse.focus_track_api.domain.general.AppUser;
import org.springframework.data.repository.CrudRepository;

public interface AppUserRepo extends CrudRepository<AppUser, Long> {
    AppUser findByUuid(String uuid);
}
