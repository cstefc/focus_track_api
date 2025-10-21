package be.osse.focus_track_api.controller.general;

import be.osse.focus_track_api.domain.general.AppUser;
import be.osse.focus_track_api.service.general.AppUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppUserController {
    private final AppUserService appUserService;

    public AppUserController(final AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @GetMapping("/user")
    @ResponseBody
    public List<AppUser> getAppUsers(){
        return appUserService.findAll();
    }

}
