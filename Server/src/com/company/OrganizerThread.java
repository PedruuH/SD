package com.company;

import java.util.concurrent.BlockingQueue;

public class OrganizerThread implements Runnable {
    private final BlockingQueue queue1;
    private final BlockingQueue queue2;
    private final BlockingQueue queue3;

    private Object command;

    public OrganizerThread(BlockingQueue _queue1, BlockingQueue _queue2, BlockingQueue _queue3) {
        queue1 = _queue1;
        queue2 = _queue2;
        queue3 = _queue3;
    }

    public void run() {
        try {
            while (true) {
                command = queue1.take();
                queue2.add(command);
                queue3.add(command);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
