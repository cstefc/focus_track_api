package be.osse.focus_track_api.security;

import be.osse.focus_track_api.domain.general.AppUser;
import be.osse.focus_track_api.domain.predefined.Role;
import be.osse.focus_track_api.service.general.AppUserService;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class FirebaseTokenFilter extends OncePerRequestFilter {

    @Value("${development-mode:false}")
    private boolean developmentMode;

    private final AppUserService appUserService;

    @Autowired
    public FirebaseTokenFilter(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader("Authorization");

        if (developmentMode) {
            AppUser appUser = appUserService.findByUuid("dev-001");

            if (appUser == null) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }

            // Set authenticated principal (we only need UID)
            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(appUser, null, appUser.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        else if (header != null && header.startsWith("Bearer ")) {
            String idToken = header.substring(7);
            try {
                // Verify ID token (checks signature & expiration)
                FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(idToken, true);

                // Load user or create new one
                AppUser appUser = appUserService.findByUuid(decodedToken.getUid());
                if (appUser == null) {
                    appUser = appUserService.save(new AppUser(decodedToken.getUid(), decodedToken.getName(), decodedToken.getEmail(), List.of(Role.USER)));
                }

                // Set authenticated principal (we only need UID)
                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(appUser, null, appUser.getAuthorities());

                SecurityContextHolder.getContext().setAuthentication(authentication);

            } catch (Exception e) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
        }

        filterChain.doFilter(request, response);
    }
}