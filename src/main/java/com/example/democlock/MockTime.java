package com.example.democlock;

public class MockTime {
    private int second = 0;

    public void tick() {
        second++;
    }

    public int getSecond() {
        return second;
    }
}
