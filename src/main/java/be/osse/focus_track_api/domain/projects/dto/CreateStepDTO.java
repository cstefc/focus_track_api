package be.osse.focus_track_api.domain.projects.dto;

public record CreateStepDTO(
        long goalId,
        int sequence,
        String objective,
        String description,
        String requirements,
        int status
) {
}
