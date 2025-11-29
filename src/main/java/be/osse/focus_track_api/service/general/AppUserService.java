package be.osse.focus_track_api.service.general;

import be.osse.focus_track_api.domain.general.AppUser;
import be.osse.focus_track_api.repository.general.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserService {

    private final AppUserRepo appUserRepo;

    @Autowired
    public AppUserService(final AppUserRepo appUserRepo) {
        this.appUserRepo = appUserRepo;
    }

    public List<AppUser> findAll() {
        return (List<AppUser>) appUserRepo.findAll();
    }

    public boolean existsByUuid(final String uuid) {
        return appUserRepo.existsByUuid(uuid);
    }

    public AppUser findByUuid(String uuid) {
        return appUserRepo.findByUuid(uuid);
    }

    public AppUser save(final AppUser appUser) {
        return appUserRepo.save(appUser);
    }

}
