package com.company;

import java.io.*;
import java.util.ArrayList;

public class FW {
    File file = new File("PrimeNumbers.txt");
    FileWriter fw;
    private SimpleTimer timer = new SimpleTimer();

    public FW(ArrayList<Integer> pnums) {
        timer.StartTimeRecording();
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println(e.getLocalizedMessage());
            }
        }

        try {
            fw = new FileWriter(file);
            for (int i = 0; i < pnums.size(); i++) {
                fw.write(pnums.get(i) + " ");
                if (i % 10 == 0 && i != 0) {
                    fw.write("\n");
                }
            }
            fw.close();
        } catch (IOException io) {
            System.out.println(io.getLocalizedMessage());
        }
        timer.EndTimeRecording();
    }

    public double GetTime() {
        return (timer.CountTime());
    }
}
