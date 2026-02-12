package be.osse.focus_track_api.domain.projects.dto;

public record UpdateProjectDTO(
        long id,

        String title,
        String description,
        boolean archived
) {}
