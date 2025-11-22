package be.osse.focus_track_api.dto.projects;

public record ProjectDTO(
        long id,

        String title,
        String description,

        boolean archived
) {}
