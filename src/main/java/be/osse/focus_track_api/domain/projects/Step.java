package be.osse.focus_track_api.domain.projects;

import be.osse.focus_track_api.domain.predefined.Status;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Step {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Goal goal;

    private int sequence;
    private String objective;
    private String description;
    private String requirements;
    private Status status;
    private Timestamp completedAt;

    public int getId() {
        return id;
    }

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Timestamp getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(Timestamp completedAt) {
        this.completedAt = completedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Step step = (Step) o;
        return id == step.id && sequence == step.sequence && Objects.equals(goal, step.goal) && Objects.equals(objective, step.objective) && Objects.equals(description, step.description) && Objects.equals(requirements, step.requirements) && status == step.status && Objects.equals(completedAt, step.completedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, goal, sequence, objective, description, requirements, status, completedAt);
    }
}
