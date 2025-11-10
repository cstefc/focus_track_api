package be.osse.focus_track_api.domain.general;

import be.osse.focus_track_api.domain.authorization.GrantedAuthorityFactory;
import be.osse.focus_track_api.domain.planning.Event;
import be.osse.focus_track_api.domain.predefined.Role;
import be.osse.focus_track_api.domain.projects.Project;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@Entity
public class AppUser implements UserDetails {

    @Id
    @Column(unique = true,  nullable = false, updatable = false)
    private String uuid;

    @OneToMany(cascade = CascadeType.ALL,  fetch = FetchType.LAZY, mappedBy = "appUser")
    private List<Project>  projects;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "appUser")
    private List<Event> events;

    private String name;
    private String email;
    private List<Role> roles;


    public AppUser() {}

    public AppUser(String uuid, String name, String email, List<Role> roles) {
        this.uuid = uuid;
        this.name = name;
        this.email = email;
        this.roles = roles;
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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public List<Event> getEvents() {
        return events;
    }

    @Override
    public List<GrantedAuthority> getAuthorities() {
        return roles.stream().map(GrantedAuthorityFactory::createGrantedAuthority).toList();
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
