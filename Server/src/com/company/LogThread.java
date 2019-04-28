package com.company;

import java.util.concurrent.BlockingQueue;

public class LogThread implements Runnable {
    private final BlockingQueue queue;

    public LogThread(BlockingQueue _queue) {
        this.queue = _queue;
    }

    public void run() {
        try {
            while (true) {
                System.out.println(queue.take().toString());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
