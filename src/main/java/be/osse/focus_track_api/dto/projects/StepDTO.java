package be.osse.focus_track_api.dto.projects;

import be.osse.focus_track_api.domain.predefined.Status;

import java.sql.Timestamp;

public record StepDTO(
        int id,
        int sequence,
        String objective,
        String description,
        String requirements,
        Status status,
        Timestamp completedAt
) {
}
