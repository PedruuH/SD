package com.company;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;

public class ReceptionThread implements Runnable {
    private Socket socket;
    private final BlockingQueue queue;
    private ObjectInputStream inputStream;

    public ReceptionThread(Socket _socket, BlockingQueue _queue) {
        this.socket = _socket;
        this.queue = _queue;
    }

    public void run() {
        try {
            inputStream = new ObjectInputStream(socket.getInputStream());

            while (true) {
                queue.put(inputStream.readObject());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
