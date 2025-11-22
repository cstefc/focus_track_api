package be.osse.focus_track_api.controller.general;

import be.osse.focus_track_api.domain.general.AppUser;
import be.osse.focus_track_api.domain.predefined.Role;
import be.osse.focus_track_api.dto.general.AppUserDTO;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppUserController {

    public AppUserController() {

    }

    @GetMapping("/user")
    public AppUserDTO getAppUsers(@AuthenticationPrincipal AppUser appUser) {
        List<Role> roles = appUser.getRoles();
        return new AppUserDTO(appUser.getUuid(), appUser.getName(), appUser.getEmail(), roles);
    }

}
