package be.osse.focus_track_api.dto.planning;

import java.sql.Date;
import java.sql.Timestamp;

public record CreateEventDTO(
        String name,
        String description,
        Date start,
        Timestamp duration,
        Timestamp finish_time,
        boolean timed
) {
}
