package com.example.democlock;


import java.util.TimerTask;

public class TimeKickTask extends TimerTask {
    private MockTime mockTime;

    public TimeKickTask(MockTime time) {
        mockTime = time;
    }

    public void run() {
        mockTime.tick();
    }
}
