package be.osse.focus_track_api.service.logging;

import be.osse.focus_track_api.domain.logging.Log;
import be.osse.focus_track_api.repository.logging.LogRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LogServiceTest {
    @Mock
    LogRepo logRepo;

    LogService logService;

    @BeforeEach
    void setUp() {
        logService = new LogService(logRepo);
    }

    @Test
    void testSave(){
        // GIVEN
        Log log = mock(Log.class);
        Log expected = mock(Log.class);
        when(logRepo.save(log)).thenReturn(expected);

        // WHEN
        Log result = logService.save(log);

        // THEN
        verify(logRepo).save(log);
        assertEquals(expected, result);

    }
}
