package be.osse.focus_track_api.dto.logging;

import java.util.List;

public record LogDTO(
        long id,
        boolean archived,
        List<EntryDTO> entries
) {
}
