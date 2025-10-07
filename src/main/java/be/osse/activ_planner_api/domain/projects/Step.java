package be.osse.activ_planner_api.domain.projects;

import be.osse.activ_planner_api.domain.projects.predefined.Status;
import jakarta.persistence.*;

@Entity
public class Step {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Plan plan;

    private int sequence;
    private String objective;
    private String description;
    private String requirements;
    private Status status;

}
