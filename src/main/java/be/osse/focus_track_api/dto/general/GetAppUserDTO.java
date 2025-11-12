package be.osse.focus_track_api.dto.general;

import be.osse.focus_track_api.domain.predefined.Role;

import java.util.List;

public record GetAppUserDTO (
        String uuid,
        String name,
        String email,
        List<Role> roles
) {
}
