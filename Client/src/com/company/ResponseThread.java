package com.company;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ResponseThread implements Runnable {
    private Socket socket;
    ObjectInputStream inputStream;

    public ResponseThread(Socket _socket) {
        this.socket = _socket;
    }

    public void run() {
        try {
            inputStream = new ObjectInputStream(socket.getInputStream());

            while (true) {
                System.out.println("Resposta: " + inputStream.readObject());
            }
        } catch (IOException e) {
            System.out.println("Não foi possível receber a mensagem do servidor!");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
