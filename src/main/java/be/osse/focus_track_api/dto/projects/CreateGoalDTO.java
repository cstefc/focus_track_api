package be.osse.focus_track_api.dto.projects;

import java.sql.Timestamp;

public record CreateGoalDTO(
        long projectId,
        String description,
        String priority,
        Timestamp estimated
) {
}