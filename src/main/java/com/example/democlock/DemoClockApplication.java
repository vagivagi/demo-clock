package com.example.democlock;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Timer;

public class DemoClockApplication {


    public static void main(String[] args) throws InterruptedException {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = ZonedDateTime.of(2017, 6, 27, 22, 0, 0, 0, zoneId);
        Clock clock = Clock.fixed(zonedDateTime.toInstant(), zoneId);
        Timer timer = new Timer(true);
        MockTime mockTime = new MockTime();
        timer.scheduleAtFixedRate(new TimeKickTask(mockTime), 1, 1);
        for (int i = 0; i < 1000; i++) {
            System.out.println("current time:" + LocalDateTime.now(Clock.offset(clock, Duration.ofSeconds(mockTime.getSecond()))).
                    format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
            Thread.sleep(10);
        }
    }

}
