package com.company;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MenuThread implements Runnable {
    private static String server;
    private static int port;
    private static InetAddress serverIpAddress;

    private Socket socket;
    private Scanner scn;
    private String command;
    private ObjectOutputStream outputStream;

    private Config config = new Config();

    public void run() {
        config.load();
        if (config.getIsLoaded()) {
            scn = new Scanner(System.in);

            server = config.getServer();
            port = config.getPort();

            try {
                serverIpAddress = InetAddress.getByName(server);
                socket = new Socket(serverIpAddress, port);

                Thread response = new Thread(new ResponseThread(socket));
                response.setDaemon(true);
                response.start();

                outputStream = new ObjectOutputStream(socket.getOutputStream());

                while (true) {
                    System.out.println("\n----------- Lista de Comandos ------------");
                    System.out.println("1. Insert <values>");
                    System.out.println("2. Select <id>");
                    System.out.println("3. Update <id> values <values>");
                    System.out.println("4. Delete <id>");
                    System.out.println("5. Exit");
                    System.out.println("------------------------------------------");
                    command = scn.nextLine();

                    if (command.equals("Exit")) {
                        Thread.sleep(5000);
                        break;
                    } else {
                        if (validation(command)) {
                            outputStream.flush();
                            outputStream.writeObject(command);
                            Thread.sleep(1000);
                        } else System.out.println("\nComando inválido!");
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("Ocorreu uma falha!\nPor favor, verifique a disponibilidade do servidor.");
                e.printStackTrace();
            }
            scn.close();
        }
    }

    public boolean validation(String text) {
        String[] elements = text.split(" ");

        switch (elements[0]) {
            case "Insert":
                if (elements.length < 2) return false;

                break;
            case "Select":
            case "Delete":
                if (elements.length != 2) return false;
                try {
                    Integer.parseInt(elements[1]);
                } catch (NumberFormatException e) {
                    return false;
                }
                break;
            case "Update":
                if (elements.length < 4 || !elements[2].equals("values")) return false;
                try {
                    Integer.parseInt(elements[1]);
                } catch (NumberFormatException e) {
                    return false;
                }
                break;
            default:
                return false;
        }
        return true;
    }

    public static void main(String argv[]) {
        Thread menu = new Thread(new MenuThread());
        menu.start();
    }
}
