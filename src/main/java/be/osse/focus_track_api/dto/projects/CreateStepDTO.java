package be.osse.focus_track_api.dto.projects;

public record CreateStepDTO(
        long goalId,
        int sequence,
        String objective,
        String description,
        String requirements,
        int status
) {
}
