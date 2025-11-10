package be.osse.focus_track_api.repository.planning;

import be.osse.focus_track_api.domain.planning.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepo extends CrudRepository<Event, Long> {
}
