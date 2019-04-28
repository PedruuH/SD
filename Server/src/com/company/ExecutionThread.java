package com.company;

import java.util.concurrent.BlockingQueue;

public class ExecutionThread implements Runnable {
    private final BlockingQueue queue;

    public ExecutionThread(BlockingQueue _queue) {
        this.queue = _queue;
    }

    public void run() {
        try {
            while (true) {
                System.out.println("Comando executado: " + queue.take().toString());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
