package be.osse.focus_track_api.domain.logging;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Log {
    @Id
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
