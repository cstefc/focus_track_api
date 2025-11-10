package be.osse.focus_track_api.domain.planning;

import be.osse.focus_track_api.domain.general.AppUser;
import be.osse.focus_track_api.domain.logging.Log;
import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private AppUser appUser;

    @OneToOne
    private Log log;

    private String name;
    private String description;
    private Date start;
    private Timestamp duration;
    private Timestamp finish_time;
    private boolean timed;

    public Long getId() {
        return id;
    }

    public String getUserUuid() {
        return appUser.getUuid();
    }

    public void setUser(AppUser appUser) {
        this.appUser = appUser;
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

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Timestamp getDuration() {
        return duration;
    }

    public void setDuration(Timestamp duration) {
        this.duration = duration;
    }

    public Timestamp getFinish_time() {
        return finish_time;
    }

    public void setFinish_time(Timestamp finish_time) {
        this.finish_time = finish_time;
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
        return timed == event.timed && Objects.equals(id, event.id) && Objects.equals(appUser, event.appUser) && Objects.equals(name, event.name) && Objects.equals(description, event.description) && Objects.equals(start, event.start) && Objects.equals(duration, event.duration) && Objects.equals(finish_time, event.finish_time) && Objects.equals(log, event.log);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, appUser, name, description, start, duration, finish_time, log, timed);
    }
}
