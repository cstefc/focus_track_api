package be.osse.focus_track_api.dto.projects;

public record GetProjectDTO(long id, String app_user_uuid, String name, String description, boolean archived) {}
