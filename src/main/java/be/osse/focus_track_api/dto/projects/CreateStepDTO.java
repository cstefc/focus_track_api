package be.osse.focus_track_api.dto.projects;

import java.sql.Timestamp;

public record CreateStepDTO(
        long goalId,
        int sequence,
        String objective,
        String description,
        String requirements,
        int status,
        Timestamp completedAt
) {
}
