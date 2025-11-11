package be.osse.focus_track_api.controller.general;

import be.osse.focus_track_api.domain.general.AppUser;
import be.osse.focus_track_api.dto.general.GetAppUserDTO;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppUserController {

    public AppUserController() {

    }

    @GetMapping("/user")
    public GetAppUserDTO getAppUsers(@AuthenticationPrincipal AppUser appUser) {
        return new GetAppUserDTO(appUser.getUuid(), appUser.getName(), appUser.getEmail());
    }

}
