package com.company;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.concurrent.BlockingQueue;

public class ExecutionThread implements Runnable {
    private final BlockingQueue<Input> queue;

    public ExecutionThread(BlockingQueue<Input> _queue) {
        this.queue = _queue;
    }

    public void run() {
        try {
            while (true) {
                Input input = queue.take();

                System.out.println("Comando executado: " + input.getCommand());

                ObjectOutputStream outputStream = input.getOutputStream();

                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.writeObject("OK");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
