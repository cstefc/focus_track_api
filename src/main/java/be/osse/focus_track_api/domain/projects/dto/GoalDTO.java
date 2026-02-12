package be.osse.focus_track_api.domain.projects.dto;

import java.time.LocalTime;

public record GoalDTO(
        long id,

        String title,
        String description,

        int priority,
        LocalTime estimated
) {
}
