package com.company.execution;

import java.util.ArrayList;
import java.util.Scanner;

public class Gen implements Runnable {
    int threads;
    int start, end;
    int temp;
    public ArrayList<Integer> primeNumbers = new ArrayList<>();
    SimpleTimer timer = new SimpleTimer();
    Scanner scanner = new Scanner(System.in);
    Thread[] threadsArray;

    @Override
    public void run() {
        Generate(start, end);
    }

    public void Choose(int amount) {
        System.out.println("How many threads to generate (1-4):");
        threads = scanner.nextInt();
        while (!(threads <= 4 && threads >= 1)) {
            System.out.println("Entered the wrong number!");
            threads = scanner.nextInt();
        }
        threadsArray = new Thread[threads];
        for (int i = 0; i < threads; i++) {
            threadsArray[i] = new Thread(this);
        }
        ThreadsStarter(amount);
    }

    public void ThreadsStarter(int amount) {
        timer.StartTimeRecording();
        if (threads == 1) {
            Generate(0, amount);
        } else {
            ThreadCreator(amount);
        }
        timer.EndTimeRecording();
    }

    public void ThreadCreator(int amount) {
        while (amount % threads != 0) {
            amount++;
            temp++;
        }
        for (int i = 0; i < threads; i++) {
            start = end + 1;
            if (i == threads - 1) {
                end = amount - temp;
            } else {
                end = (amount / threads) * (i + 1);
            }
            threadsArray[i].start();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < threads; i++) {
            try {
                threadsArray[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void Generate(int start, int amount) {
        for (; start < amount; start++) {
            if (Check(start)) {
                primeNumbers.add(start);
            }
        }
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
        return (timer.CountTime());
    }
}

