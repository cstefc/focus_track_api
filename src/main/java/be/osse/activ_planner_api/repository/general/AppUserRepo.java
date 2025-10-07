package be.osse.activ_planner_api.repository.general;

import be.osse.activ_planner_api.domain.general.AppUser;
import org.springframework.data.repository.CrudRepository;

public interface AppUserRepo extends CrudRepository<AppUser, Long> {

}
