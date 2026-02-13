package be.osse.focus_track_api.domain.planning.dto;

import java.sql.Timestamp;

public record CreateEventDTO(
        String name,
        String description,

        Timestamp start,
        Timestamp planned_stop,

        boolean timed
) {
}
