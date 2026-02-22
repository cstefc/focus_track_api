package be.osse.focus_track_api.domain.projects.dto;

import be.osse.focus_track_api.domain.predefined.Priority;

public record UpdateGoalDTO(
        long id,

        String title,
        String description,

        Priority priority,
        Long estimated
) {
}