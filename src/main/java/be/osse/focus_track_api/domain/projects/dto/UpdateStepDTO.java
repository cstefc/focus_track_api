package be.osse.focus_track_api.domain.projects.dto;

import java.sql.Timestamp;

public record UpdateStepDTO(
        long id,
        int sequence,
        String objective,
        String description,
        String requirements,
        int status,
        Timestamp completedAt
) {
}
