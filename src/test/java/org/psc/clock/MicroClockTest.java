package org.psc.clock;

import java.sql.Timestamp;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class MicroClockTest {

    @Test
    void testMicroClock() throws InterruptedException {
        Clock microClock = new MicroClock();
        Timestamp now = Timestamp.from(microClock.instant());
        log.info("now = {}", now);

        Thread.sleep(1234);

        Timestamp now1 = Timestamp.from(microClock.instant());
        Timestamp now2 = Timestamp.from(microClock.instant());
        log.info("now1 = {}", now1);
        log.info("now2 = {}", now2);

        log.info(LocalDateTime.ofInstant(microClock.instant(), ZoneId.systemDefault()).toString());
        log.info(LocalDateTime.ofInstant(microClock.instant(), ZoneId.systemDefault()).format(
                DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss.SSSSSS")));
    }
}
