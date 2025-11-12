package be.osse.focus_track_api.dto.logging;

import java.util.List;

public record GetLogDTO(
        long id,
        boolean archived,
        List<GetEntryDTO> entries
) {
}
