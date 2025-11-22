package be.osse.focus_track_api.dto.projects;

import be.osse.focus_track_api.domain.predefined.Priority;

import java.time.LocalTime;

public record CreateGoalDTO(
        long projectId,

        String title,
        String description,

        Priority priority,
        LocalTime estimated
) {
}