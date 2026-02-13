package be.osse.focus_track_api.domain.logging.dto;

import be.osse.focus_track_api.domain.predefined.EntryType;

public record CreateEntryDTO(
        long log_id,
        String title,
        String description,
        EntryType entry_type,
        int scoring
) {
}
