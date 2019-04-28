package com.company;

import java.util.concurrent.BlockingQueue;

public class LogThread implements Runnable {
    private final BlockingQueue queue;
    private Log log = new Log();
    private String command;

    public LogThread(BlockingQueue _queue) {
        this.queue = _queue;
    }

    public void run() {
        try {
            while (true) {
                log.open();
                command = queue.take().toString();
                if (!command.contains("Select")) log.write(command);
                log.close();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            log.close();
        }
    }
}
