package be.osse.focus_track_api.dto.projects;

public record GetProjectDTO(
        long id,

        String title,
        String description,

        boolean archived
) {}
