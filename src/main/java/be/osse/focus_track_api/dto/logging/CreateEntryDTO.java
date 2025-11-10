package be.osse.focus_track_api.dto.logging;

public record CreateEntryDTO(
        long logId,
        String title,
        String description,
        int scoring,
        String type
) {
}
