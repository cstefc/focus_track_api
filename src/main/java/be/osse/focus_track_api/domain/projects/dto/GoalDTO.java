package be.osse.focus_track_api.domain.projects.dto;

public record GoalDTO(
        long id,

        String title,
        String description,

        int priority,
        Long estimated
) {
}
