package be.osse.focus_track_api.domain.general;

import be.osse.focus_track_api.domain.authorization.GrantedAuthorityFactory;
import be.osse.focus_track_api.domain.authorization.Role;
import be.osse.focus_track_api.domain.projects.Project;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Objects;

@Entity
public class AppUser implements UserDetails {

    @Id
    @Column(unique = true,  nullable = false, updatable = false)
    private String uuid;

    private String name;

    private String email;

    private List<Role> roles;

    @OneToMany(cascade = CascadeType.ALL,  fetch = FetchType.EAGER, mappedBy = "owner")
    private List<Project>  projects;

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

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return Objects.equals(uuid, appUser.uuid) && Objects.equals(name, appUser.name) && Objects.equals(email, appUser.email) && Objects.equals(roles, appUser.roles) && Objects.equals(projects, appUser.projects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, name, email, roles, projects);
    }
}
