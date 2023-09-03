package org.example.generator;

import java.util.Objects;
import java.util.Scanner;

import static org.example.generator.FileWorker.fileWriter;
import static org.example.generator.Generator.generatePassword;

public class MainRun {
    public static void run(Scanner in) {

        System.out.println("enter website address");
        String website = in.next();
        System.out.println("enter login");
        String login = in.next();
        String password = generatePassword();

        String data = String.format("""
                ()
                address -> %s;
                login -> %s;
                password -> %s;
                ()
                """, website, login, password);

        System.out.printf("""
                your data is...
                %s
                right?
                """, data);
        if (Objects.equals(in.next(), "no"))
            run(in);
        else {
            fileWriter(data);
            System.out.println("thanks for using this apps");
        }
        System.out.println("continue?");
        String answer = in.next();
        if (!answer.equals("no"))
            run(in);
    }

}
