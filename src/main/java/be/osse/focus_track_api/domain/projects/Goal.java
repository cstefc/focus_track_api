package be.osse.focus_track_api.domain.projects;

import be.osse.focus_track_api.domain.predefined.Priority;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Project project;

    @OneToMany(mappedBy = "goal", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Step> steps;

    @Column(nullable = false)
    private String title;
    private String description;

    @Column(nullable = false)
    private Priority priority = Priority.Medium;
    private Timestamp estimated;

    public Goal(){}

    public Long getId() {
        return id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
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

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Timestamp getEstimated() {
        return estimated;
    }

    public void setEstimated(Timestamp estimated) {
        this.estimated = estimated;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Goal goal = (Goal) o;
        return Objects.equals(id, goal.id) && Objects.equals(project, goal.project) && Objects.equals(steps, goal.steps) && Objects.equals(description, goal.description) && priority == goal.priority && Objects.equals(estimated, goal.estimated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, project, steps, description, priority, estimated);
    }
}
