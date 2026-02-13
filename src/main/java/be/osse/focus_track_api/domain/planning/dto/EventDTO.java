package be.osse.focus_track_api.domain.planning.dto;

import java.sql.Timestamp;

public record EventDTO(
        long id,
        long log_id,

        String name,
        String description,

        Timestamp start,
        Timestamp planned_stop,
        Timestamp stop,

        boolean timed
) {
}
