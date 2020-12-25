package com.example.democlock;

public class MockTime {
    private final long start;


    public MockTime() {
        this.start = System.currentTimeMillis();
    }

    public long duration() {
        return System.currentTimeMillis() - start;
    }
}
