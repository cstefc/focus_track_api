package be.osse.focus_track_api.repository.logging;

import be.osse.focus_track_api.domain.logging.Log;
import org.springframework.data.repository.CrudRepository;

public interface LogRepo  extends CrudRepository<Log, Long> {
}