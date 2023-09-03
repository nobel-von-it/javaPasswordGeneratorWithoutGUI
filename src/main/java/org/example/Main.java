package org.example;

import java.util.Scanner;

import static org.example.generator.FileWorker.clearFile;
import static org.example.generator.MainRun.run;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            printMenu();
            switch (in.nextInt()) {
                case 1 -> run(in);
                case 2 -> clearFile();
                case 3 -> System.exit(0);
                default -> System.out.println("incorrect input. try again");
            }
        }
    }
    public static void printMenu() {
        System.out.println("1. generate password");
        System.out.println("2. empty passwords file");
        System.out.println("3. kill app");
    }
}