package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Gen implements Runnable {
    ArrayList<Integer> primeNumbers = new ArrayList<>();
    SimpleTimer timer = new SimpleTimer();
    Scanner scanner = new Scanner(System.in);
    Thread thread1 = new Thread(this);
    Thread thread2 = new Thread(this);
    Thread thread3 = new Thread(this);
    Thread thread4 = new Thread(this);
    int threads;
    int start, end;
    int temp;

    @Override
    public void run() {
        Generate(start, end);
    }

    public void Choose(int amount) {
        System.out.println("How many threads to generate (1-4):");
        threads = scanner.nextInt();
        while (!(threads <=4 && threads >=1)) {
            System.out.println("Entered the wrong number!");
            threads = scanner.nextInt();
        }
        ThreadsStarter(amount);
    }

    public void ThreadsStarter(int amount) {
        timer.StartTimeRecording();
        switch (threads) {
            case 1:
                Generate(0, amount);
                break;
            case 2:
                if (amount % 2 != 0) {
                    amount++;
                    temp++;
                }
                start = 0;
                end = amount / 2;
                thread1.start();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                start = end+1;
                end = amount-temp;
                thread2.start();
                try {
                    thread1.join();
                    thread2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                while (amount % 3 != 0) {
                    amount++;
                    temp++;
                }
                start = 0;
                end = amount / 3;
                thread1.start();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                start = end+1;
                end *= 2;
                thread2.start();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                start = end+1;
                end = amount - temp;
                thread3.start();
                try {
                    thread1.join();
                    thread2.join();
                    thread3.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case 4:
                while (amount % 4 != 0) {
                    amount++;
                    temp++;
                }
                start = 0;
                end = amount / 4;
                thread1.start();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                start = end+1;
                end = amount / 2;
                thread2.start();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                start = end+1;
                end = (amount / 4) * 3;
                thread3.start();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                start = end+1;
                end = amount - temp;
                thread4.start();
                try {
                    thread1.join();
                    thread2.join();
                    thread3.join();
                    thread4.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
        }
        timer.EndTimeRecording();
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

    public String GetTime() {
        return (timer.CountTime() + " in " + Thread.currentThread().getName());
    }
}

