package be.osse.focus_track_api.domain.planning;

import be.osse.focus_track_api.domain.general.AppUser;
import be.osse.focus_track_api.domain.logging.Log;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private AppUser appUser;

    @OneToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Log log = new Log();

    @Column(nullable = false)
    private String title;
    private String description;

    @Column(nullable = false)
    private Timestamp start;

    @Column(nullable = false)
    private Timestamp plannedStop;
    private Timestamp stop;

    private boolean timed;

    public long getId() {
        return id;
    }

    public String getUserUuid() {
        return appUser.getUuid();
    }

    public void setUser(AppUser appUser) {
        this.appUser = appUser;
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

    public Timestamp getStart() {
        return start;
    }

    public void setStart(Timestamp start) {
        this.start = start;
    }

    public Timestamp getPlannedStop() {
        return plannedStop;
    }

    public void setPlannedStop(Timestamp plannedStop) {
        this.plannedStop = plannedStop;
    }

    public Timestamp getStop() {
        return stop;
    }

    public void setStop(Timestamp stop) {
        this.stop = stop;
    }

    public Log getLog() {
        return log;
    }

    public void setLog(Log log) {
        this.log = log;
    }

    public boolean isTimed() {
        return timed;
    }

    public void setTimed(boolean timed) {
        this.timed = timed;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return timed == event.timed && Objects.equals(id, event.id) && Objects.equals(appUser, event.appUser) && Objects.equals(title, event.title) && Objects.equals(description, event.description) && Objects.equals(start, event.start) && Objects.equals(plannedStop, event.plannedStop) && Objects.equals(stop, event.stop) && Objects.equals(log, event.log);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, appUser, title, description, start, plannedStop, stop, log, timed);
    }
}
