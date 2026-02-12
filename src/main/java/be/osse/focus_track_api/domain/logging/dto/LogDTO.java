package be.osse.focus_track_api.domain.logging.dto;

import java.util.List;

public record LogDTO(
        long id,
        boolean archived,
        List<EntryDTO> entries
) {
}
