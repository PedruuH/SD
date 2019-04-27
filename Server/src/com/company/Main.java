package com.company;

        import java.io.*;
        import java.net.ServerSocket;
        import java.net.Socket;

public class Main {

    public static void main(String argv[]) throws Exception {
        String message = "";

        int port = 6789;

        ServerSocket welcomeSocket = new ServerSocket(port);
        System.out.println("Servidor ouvindo a porta " + port);

        Socket connectionSocket = welcomeSocket.accept();
        System.out.println("Cliente conectado: " + connectionSocket.getInetAddress().getHostAddress());

        ObjectOutputStream outputStream = new ObjectOutputStream(connectionSocket.getOutputStream());
        ObjectInputStream inputStream = new ObjectInputStream(connectionSocket.getInputStream());

        outputStream.flush();
        outputStream.writeObject("Conexão estabelecida!");

        while (!message.equals("Exit")) {
            message = inputStream.readObject().toString();
            if (!message.equals("")) {
                System.out.println(message);
                outputStream.flush();
                outputStream.writeObject("Ok");
            }
        }

        outputStream.flush();
        outputStream.writeObject("Conexão encerrada!");
        outputStream.close();
        inputStream.close();
        System.out.println("Conexão encerrada!");
    }
}
