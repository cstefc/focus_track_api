package be.osse.focus_track_api.domain.projects.dto;

public record CreateProjectDTO (
        String title,
        String description,
        boolean archived
) {}
