package be.osse.focus_track_api.domain.projects.dto;

import be.osse.focus_track_api.domain.predefined.Priority;

public record CreateGoalDTO(
        long projectId,

        String title,
        String description,

        Priority priority,
        Long estimated
) {
}