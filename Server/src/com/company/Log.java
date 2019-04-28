package com.company;

import java.io.*;

public class Log {
    private String file = "log.txt";
    private FileWriter fileWriter;
    private PrintWriter printWriter;
    private boolean isOpen = false;

    public void open() {
        try {
            if (!isOpen) {
                fileWriter = new FileWriter(file,true);
                printWriter = new PrintWriter(fileWriter);

                isOpen = true;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            if (isOpen) {
                fileWriter.close();
                isOpen = false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(String content) {
       if (isOpen) { printWriter.printf(content + "%n"); System.out.println("Comando gravado no arquivo log."); }
       else System.out.println("O arquivo " + file + " não está aberto!");
    }
}
