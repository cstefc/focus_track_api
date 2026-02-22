package be.osse.focus_track_api.domain.general;

import be.osse.focus_track_api.domain.planning.Event;
import be.osse.focus_track_api.domain.projects.Project;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@Entity
@Table(name="app_user")
public class AppUser implements UserDetails {

    @Id
    @Column(unique = true,  nullable = false, updatable = false)
    private String uuid;

    @OneToMany(cascade = CascadeType.ALL,  fetch = FetchType.LAZY, mappedBy = "appUser")
    private List<Project>  projects;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "appUser")
    private List<Event> events;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    public AppUser() {}

    public AppUser(String uuid, String name, String email) {
        this.uuid = uuid;
        this.name = name;
        this.email = email;
    }

    public String getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public List<Event> getEvents() {
        return events;
    }

    @Override
    public List<GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.uuid;
    }

}
