package be.osse.focus_track_api.domain.logging;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL,  fetch = FetchType.LAZY, mappedBy = "log")
    private List<Entry> entries;

    private boolean archived;

    public Long getId() {
        return id;
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
        Log log = (Log) o;
        return archived == log.archived && Objects.equals(id, log.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, archived);
    }
}
