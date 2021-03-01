package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int answer;
        do {
            System.out.println("Generate numbers or get them from the file:");
            int check;
            Gen gen = new Gen();
            Scanner scanner = new Scanner(System.in);
            check = scanner.nextInt();
            FR fr = null;
            FW fw = null;
            while (check != 1 && check != 2) {
                System.out.println("Entered the wrong number!");
                check = scanner.nextInt();
            }
            if (check == 1) {
                gen.Generate();
            } else {
                fr = new FR();
                gen.primeNumbers = fr.pFileNums;
            }
            System.out.println("Print the results or save them:");
            check = scanner.nextInt();
            while (check != 1 && check != 2) {
                System.out.println("Entered the wrong number!");
                check = scanner.nextInt();
            }
            if (check == 1) {
                System.out.println(gen.primeNumbers);
            } else {
                fw = new FW(gen.primeNumbers);
            }

            System.out.println("Enter the number:");
            check = scanner.nextInt();
            Executor executor = new Executor();
            executor.FindBounds(gen.primeNumbers, check);
            System.out.println(executor.getA());
            System.out.println(executor.getB());
            System.out.println(executor.getBounds());
            if (fr == null) {
                System.out.println("Time of execution of the generation:" + gen.GetTime());
            }
            System.out.println("Time of execution of the execution:" + executor.GetTime());
            if (fr != null) {
                System.out.println("Time of execution of the reading the file:" + fr.GetTime());
            }
            if (fw != null) {
                System.out.println("Time of execution of the writing to the file:" + fw.GetTime());
            }
            System.out.println("Enter 0 to exit:");
            answer = scanner.nextInt();
        } while (answer != 0);
    }

}
