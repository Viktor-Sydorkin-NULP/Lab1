package com.company;

import java.util.ArrayList;

public class Gen {
    ArrayList<Integer> primeNumbers = new ArrayList<>();
    SimpleTimer timer = new SimpleTimer();

    public void Generate() {
        timer.StartTimeRecording();
        for (int i = 0; i < 100000; i++) {
            if (Check(i)) {
                primeNumbers.add(i);
            }
        }
        timer.EndTimeRecording();
    }

    private boolean Check(int n) {
        for (int i = 2; i < n - 1; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public double GetTime() {
        return timer.CountTime();
    }
}

