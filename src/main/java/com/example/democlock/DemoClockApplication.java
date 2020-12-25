package com.example.democlock;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Timer;

public class DemoClockApplication {

    public static void main(String[] args) throws InterruptedException {
        // ゾーン指定（Asia/Tokyo）
        ZoneId zoneId = ZoneId.systemDefault();
        // 日付と時刻指定
        ZonedDateTime zonedDateTime = ZonedDateTime.of(2017, 6, 27, 22, 0, 0, 0, zoneId);
        // 指定したTimeゾーンと時刻でClockクラスのインスタンス生成
        Clock clock = Clock.fixed(zonedDateTime.toInstant(), zoneId);
        // Timer設定
        Timer timer = new Timer(true);
        MockTime mockTime = new MockTime();
        for (int i = 0; i < 1000; i++) {
            System.out.println("current time:" + LocalDateTime.now(Clock.offset(clock, Duration.ofSeconds(mockTime.duration()))).
                    format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
            Thread.sleep(10);
        }
    }

}
