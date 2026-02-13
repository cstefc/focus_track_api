package be.osse.focus_track_api.domain.projects.dto;

import be.osse.focus_track_api.domain.predefined.Priority;

import java.time.LocalTime;

public record UpdateGoalDTO(
        long id,

        String title,
        String description,

        Priority priority,
        LocalTime estimated
) {
}