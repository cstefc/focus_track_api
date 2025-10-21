package be.osse.focus_track_api.domain.projects;

import be.osse.focus_track_api.domain.general.AppUser;
import be.osse.focus_track_api.domain.logging.Log;
import be.osse.focus_track_api.dto.project.CreateProjectDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private AppUser owner;

    private String name;

    private String description;

    @OneToMany(mappedBy = "project", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Plan> plans;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Log log;

    public Project() {}

    public Project(AppUser owner, CreateProjectDTO createProjectDTO) {
        this.owner = owner;
        this.name = createProjectDTO.name();
        this.description = createProjectDTO.description();
        this.log = null;
        this.plans = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Plan> getPlans() {
        return plans;
    }

    public void setPlans(List<Plan> plans) {
        this.plans = plans;
    }

    public Log getLog() {
        return log;
    }

    public void setLog(Log log) {
        this.log = log;
    }

    public String getOwnerUuid() {
        return owner.getUuid();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(id, project.id) && Objects.equals(owner, project.owner) && Objects.equals(name, project.name) && Objects.equals(description, project.description) && Objects.equals(plans, project.plans) && Objects.equals(log, project.log);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, owner, name, description, plans, log);
    }
}
