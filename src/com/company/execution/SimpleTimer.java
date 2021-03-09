package com.company.execution;

public class SimpleTimer {
    private long startTime = 0;
    private long endTime = 0;

    public void StartTimeRecording() {
        startTime = System.currentTimeMillis();
    }

    public void EndTimeRecording() {
        endTime = System.currentTimeMillis();
    }

    public double CountTime() {
        return ((endTime - startTime) / 1000.0);
    }
}
