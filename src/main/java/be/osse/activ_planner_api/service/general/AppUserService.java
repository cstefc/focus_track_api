package be.osse.activ_planner_api.service.general;

import be.osse.activ_planner_api.domain.general.AppUser;
import be.osse.activ_planner_api.repository.general.AppUserRepo;
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


}
