package be.osse.focus_track_api.controller.general;

import be.osse.focus_track_api.domain.general.AppUser;
import be.osse.focus_track_api.dto.general.AppUserDTO;
import be.osse.focus_track_api.service.general.AppUserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppUserController {

    private final AppUserService appUserService;

    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @GetMapping("/user")
    public AppUserDTO getAppUsers(@AuthenticationPrincipal String uuid) {
        final AppUser appUser = appUserService.findByUuid(uuid);
        return new AppUserDTO(appUser.getUuid(), appUser.getName(), appUser.getEmail(), List.of());
    }

}
