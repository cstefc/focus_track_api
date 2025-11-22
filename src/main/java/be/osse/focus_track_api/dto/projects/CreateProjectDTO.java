package be.osse.focus_track_api.dto.projects;

public record CreateProjectDTO (
        String title,
        String description,
        boolean archived
) {}
