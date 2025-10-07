package be.osse.activ_planner_api.domain.projects;

import be.osse.activ_planner_api.domain.logging.Log;
import be.osse.activ_planner_api.domain.projects.predefined.Priority;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String goal;
    private Priority priority;
    private Timestamp estimated;

    @OneToOne(cascade = CascadeType.ALL,  fetch = FetchType.EAGER)
    private Log log;

    @ManyToOne
    private Project project;

    @OneToMany(mappedBy = "plan", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Step> steps;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
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

    public Log getLog() {
        return log;
    }

    public void setLog(Log log) {
        this.log = log;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Plan plan = (Plan) o;
        return Objects.equals(id, plan.id) && Objects.equals(goal, plan.goal) && priority == plan.priority && Objects.equals(estimated, plan.estimated) && Objects.equals(log, plan.log) && Objects.equals(project, plan.project) && Objects.equals(steps, plan.steps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, goal, priority, estimated, log, project, steps);
    }
}
