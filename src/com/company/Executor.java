package com.company;

import java.util.ArrayList;

public class Executor {
    private int a;
    private int b;
    private int bounds;
    private SimpleTimer timer = new SimpleTimer();

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void setBounds(int bounds) {
        this.bounds = bounds;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getBounds() {
        return bounds;
    }

    public void FindBounds(ArrayList<Integer> primeNumbers, int check) {
        timer.StartTimeRecording();
        int temp = 0;
        for (int i = 0; i < primeNumbers.size(); i++) {
            if (primeNumbers.get(i) > check) {
                do {
                    primeNumbers.remove(i);
                } while (primeNumbers.size() != i);
                break;
            }
        }
        System.out.println(primeNumbers);
        for (int i = 0; i < primeNumbers.size() - 1; i++) {
            if (i == 0) {
                temp = primeNumbers.get(i + 1) - primeNumbers.get(i);
                setA(primeNumbers.get(i));
                setB(primeNumbers.get(i + 1));
                setBounds(temp);
            } else {
                if (primeNumbers.get(i + 1) - primeNumbers.get(i) >= temp) {
                    temp = primeNumbers.get(i + 1) - primeNumbers.get(i);
                    setA(primeNumbers.get(i));
                    setB(primeNumbers.get(i + 1));
                    setBounds(temp);
                }
            }
        }
        timer.EndTimeRecording();
    }

    public double GetTime() {
        return (timer.CountTime());
    }
}
