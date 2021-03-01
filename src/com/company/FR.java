package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class FR {
    File file = new File("PrimeNumbers.txt");
    BufferedReader br;
    ArrayList<Integer> pFileNums = new ArrayList<>();
    private SimpleTimer timer = new SimpleTimer();
    public FR() {
        timer.StartTimeRecording();
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getLocalizedMessage());
        }
        try {
            String tmp= br.readLine();
            while (tmp != null) {
                pFileNums.addAll(Arrays.stream(tmp.split(" ")).map(Integer::parseInt).collect(Collectors.toList()));
                tmp=br.readLine();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        timer.EndTimeRecording();
    }
    public double GetTime() {
        return timer.CountTime();
    }
}
