package be.osse.focus_track_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration.class
})
public class FocusTrackApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FocusTrackApiApplication.class, args);
    }

}
