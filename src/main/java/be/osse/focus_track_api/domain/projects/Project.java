package be.osse.focus_track_api.domain.projects;

import be.osse.focus_track_api.domain.logging.Log;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @OneToMany(mappedBy = "project", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Plan> plans;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Log log;

}
