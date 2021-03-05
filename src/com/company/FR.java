package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FR implements Runnable {
    File file = new File("PrimeNumbers.txt");
    BufferedReader br;
    ArrayList<Integer> pFileNums = new ArrayList<>();
    private SimpleTimer timer = new SimpleTimer();
    Thread thread1 = new Thread(this);
    Thread thread2 = new Thread(this);
    Thread thread3 = new Thread(this);
    Thread thread4 = new Thread(this);
    int threads;
    Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
        while (true) {
            synchronized (scanner) {
                try {
                    scanner.notify();
                    String tmp = null;
                    try {
                        tmp = br.readLine();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    if (tmp != null) {
                        pFileNums.addAll(Arrays.stream(tmp.split(" ")).map(Integer::parseInt).collect(Collectors.toList()));
                    }
                    scanner.wait(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public FR() {
        timer.StartTimeRecording();
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getLocalizedMessage());
        }
        System.out.println("How many threads to generate (1-4):");
        threads = scanner.nextInt();
        while (!(threads <= 4 && threads >= 1)) {
            System.out.println("Entered the wrong number!");
            threads = scanner.nextInt();
        }
        CreateThreads(threads);
        timer.EndTimeRecording();
    }

    public void CreateThreads(int threads) {
        switch (threads) {
            case 1:
                thread1.start();
                break;
            case 2:
                thread1.start();
                thread2.start();
                break;
            case 3:
                thread1.start();
                thread2.start();
                thread3.start();
                break;
            case 4:
                thread1.start();
                thread2.start();
                thread3.start();
                thread4.start();
                break;
        }
    }

    public double GetTime() {
        return (timer.CountTime());
    }
}
