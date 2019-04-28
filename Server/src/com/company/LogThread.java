package com.company;

import java.util.concurrent.BlockingQueue;

public class LogThread implements Runnable {
    private final BlockingQueue queue;
    private Log log = new Log();

    public LogThread(BlockingQueue _queue) {
        this.queue = _queue;
    }

    public void run() {
        try {
            while (true) {
                log.open();
                log.write(queue.take().toString());
                log.close();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            log.close();
        }
        finally {
            log.close();
        }
    }
}
