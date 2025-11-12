package be.osse.focus_track_api.dto.projects;

import be.osse.focus_track_api.domain.predefined.Priority;

import java.sql.Timestamp;

public record GetGoalDTO(
        long id,

        String title,
        String description,

        Priority priority,
        Timestamp estimated
) {
}
