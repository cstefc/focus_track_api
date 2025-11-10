package be.osse.focus_track_api.domain.logging;

import be.osse.focus_track_api.domain.predefined.EntryType;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Log log;
    private String title;
    private String description;
    private int scoring;
    private EntryType entryType;

    public Long getId() {
        return id;
    }

    public Log getLog() {
        return log;
    }

    public void setLog(Log log) {
        this.log = log;
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

    public int getScoring() {
        return scoring;
    }

    public void setScoring(int scoring) {
        this.scoring = scoring;
    }

    public EntryType getEntryType() {
        return entryType;
    }

    public void setEntryType(EntryType entryType) {
        this.entryType = entryType;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return scoring == entry.scoring && Objects.equals(id, entry.id) && Objects.equals(log, entry.log) && Objects.equals(title, entry.title) && Objects.equals(description, entry.description) && entryType == entry.entryType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, log, title, description, scoring, entryType);
    }
}
