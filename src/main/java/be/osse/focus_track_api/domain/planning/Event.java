package be.osse.focus_track_api.domain.planning;

import be.osse.focus_track_api.domain.general.AppUser;
import be.osse.focus_track_api.domain.general.Reference;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name="event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="app_user_uuid")
    private AppUser appUser;

    @ManyToOne
    private Reference reference;

    @Column(nullable = false)
    private String title;

    @Column
    private String description;

    @Column(nullable = false)
    private Timestamp start;

    private Timestamp stop;

    public Long getId() {
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

    public Timestamp getStop() {
        return stop;
    }

    public void setStop(Timestamp stop) {
        this.stop = stop;
    }

    public Reference getReference() {
        return reference;
    }

    public void setReference(Reference reference) {
        this.reference = reference;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(id, event.id) && Objects.equals(appUser, event.appUser) && Objects.equals(title, event.title) && Objects.equals(description, event.description) && Objects.equals(start, event.start) && Objects.equals(stop, event.stop);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, appUser, title, description, start, stop);
    }
}
