package be.osse.focus_track_api.domain.authorization;

import org.springframework.security.core.GrantedAuthority;

public class GrantedAuthorityFactory {
    public static GrantedAuthority createGrantedAuthority(Role role) {
        return () -> "ROLE_" + role.name().toUpperCase();
    }
}
