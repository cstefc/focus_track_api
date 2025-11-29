package be.osse.focus_track_api.dto.projects;

public record StepDTO(
        Long id,
        int sequence,
        String objective,
        String description,
        String requirements,
        int status
) {
}
