package be.osse.focus_track_api.domain.logging.dto;

import be.osse.focus_track_api.domain.predefined.EntryType;

public record EntryDTO(
        long id,
        String title,
        String description,
        int scoring,
        EntryType type) {}
