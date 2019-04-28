package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    public static void main(String argv[]) throws Exception {
        int port = 6789;
        BlockingQueue queue1 = new LinkedBlockingQueue();
        BlockingQueue queue2 = new LinkedBlockingQueue();
        BlockingQueue queue3 = new LinkedBlockingQueue();

        try {
            ServerSocket welcomeSocket = new ServerSocket(port);
            System.out.println("Servidor ouvindo a porta " + port);

            Socket connectionSocket = welcomeSocket.accept();
            System.out.println("Cliente conectado: " + connectionSocket.getInetAddress().getHostAddress());

            Thread reception = new Thread(new ReceptionThread(connectionSocket, queue1));
            reception.setDaemon(true);
            reception.start();

            Thread organizer = new Thread(new OrganizerThread(queue1, queue2, queue3));
            organizer.setDaemon(true);
            organizer.start();

            Thread execution = new Thread(new ExecutionThread(queue3));
            execution.setDaemon(true);
            execution.start();

            Thread log = new Thread(new LogThread(queue2));
            log.setDaemon(true);
            log.start();

            ObjectOutputStream outputStream = new ObjectOutputStream(connectionSocket.getOutputStream());

            outputStream.flush();
            outputStream.writeObject("Conexão estabelecida!");

            while (true) {
                /*outputStream.flush();
                outputStream.writeObject("Ok");*/


            }
        } catch (Exception e) {
            System.out.println("Conexão encerrada!");
        }
    }
}
