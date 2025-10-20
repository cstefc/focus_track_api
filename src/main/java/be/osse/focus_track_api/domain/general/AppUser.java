package be.osse.focus_track_api.domain.general;

import be.osse.focus_track_api.domain.projects.Project;
import jakarta.persistence.*;
import org.hibernate.annotations.NaturalId;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NaturalId
    @Column(unique = true,  nullable = false, updatable = false)
    private String uuid = UUID.randomUUID().toString();

    private String name;

    private String email;

    @OneToMany(cascade = CascadeType.ALL,  fetch = FetchType.EAGER, mappedBy = "owner")
    private List<Project>  projects;

    public AppUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return Objects.equals(id, appUser.id) && Objects.equals(uuid, appUser.uuid) && Objects.equals(name, appUser.name) && Objects.equals(email, appUser.email) && Objects.equals(projects, appUser.projects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, uuid, name, email, projects);
    }
}
