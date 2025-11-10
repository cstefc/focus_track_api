package be.osse.focus_track_api.service.logging;

import be.osse.focus_track_api.domain.logging.Log;
import be.osse.focus_track_api.repository.logging.LogRepo;
import org.springframework.stereotype.Service;

@Service
public class LogService {
    private final LogRepo logRepo;

    public LogService(LogRepo logRepo) {
        this.logRepo = logRepo;
    }

    public Log save(Log log){
        return logRepo.save(log);
    }

}
