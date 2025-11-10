package be.osse.focus_track_api.repository.logging;

import be.osse.focus_track_api.domain.logging.Entry;
import org.springframework.data.repository.CrudRepository;

public interface EntryRepo extends CrudRepository<Entry, Long> {
}
