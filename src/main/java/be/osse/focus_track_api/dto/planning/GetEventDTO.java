package be.osse.focus_track_api.dto.planning;

import java.sql.Timestamp;

public record GetEventDTO(
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
