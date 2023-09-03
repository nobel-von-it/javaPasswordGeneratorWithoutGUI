package org.example.generator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileWorker {
    public static void fileWriter(String data) {
        OutputStream os = null;
        File passwordsFile = new File("/home/maksim/passwords.txt");
        try {
            passwordsFile = new File("/home/maksim/passwords.txt");
            if (!passwordsFile.exists()) {
                passwordsFile.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("any error");
            e.printStackTrace();
        }

        try {
            os = new FileOutputStream(passwordsFile, true);
            os.write(data.getBytes(), 0, data.length());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert os != null;
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void clearFile() {
        File file = new File("/home/maksim/passwords.txt");
        if (!file.exists()) {
            System.out.println("file not exists");
            return;
        } else {
            OutputStream os = null;
            try {
                os = new FileOutputStream(file, false);
                os.write("".getBytes(), 0, 0);
            } catch (IOException e) {
                System.out.println("rewrite error");
                e.printStackTrace();
            } finally {
                try {
                    assert os != null;
                    os.close();
                } catch (IOException e) {
                    System.out.println("close error");
                    e.printStackTrace();
                }
            }
            System.out.println("clear is done!");
        }
    }
    public static void showLogs() {

    }
}
