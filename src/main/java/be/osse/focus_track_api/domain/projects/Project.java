package be.osse.focus_track_api.domain.projects;

import be.osse.focus_track_api.domain.general.AppUser;
import be.osse.focus_track_api.domain.logging.Log;
import be.osse.focus_track_api.dto.projects.CreateProjectDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private AppUser appUser;

    @OneToMany(mappedBy = "project", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Goal> goals;

    @OneToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Log log = new Log();

    @Column(nullable = false)
    private String title;
    private String description;
    private boolean archived = false;

    public Project() {}

    public Project(AppUser appUser, CreateProjectDTO createProjectDTO) {
        this.appUser = appUser;
        this.title = createProjectDTO.name();
        this.description = createProjectDTO.description();
        this.log = null;
        this.goals = new ArrayList<>();
        this.archived = false;
    }

    public Long getId() {
        return id;
    }

    public AppUser getUser() {
        return appUser;
    }

    public void setUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public List<Goal> getGoals() {
        return goals;
    }

    public void setGoals(List<Goal> goals) {
        this.goals = goals;
    }

    public Log getLog() {
        return log;
    }

    public void setLog(Log log) {
        this.log = log;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return archived == project.archived && Objects.equals(id, project.id) && Objects.equals(appUser, project.appUser) && Objects.equals(goals, project.goals) && Objects.equals(log, project.log) && Objects.equals(title, project.title) && Objects.equals(description, project.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, appUser, goals, log, title, description, archived);
    }
}
