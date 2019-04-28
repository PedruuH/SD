package com.company;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MenuThread implements Runnable {
    private static String config = "config.txt";
    private static String server;
    private static int port;
    private static InetAddress serverIpAddress;

    private Socket socket;
    private Scanner scn;
    private String command;
    ObjectOutputStream outputStream;

    public boolean loadConfig() {
        try {
            FileReader file = new FileReader(config);
            BufferedReader fileReader = new BufferedReader(file);

            String line = fileReader.readLine();

            String[] fields;

            while (line != null) {
                fields = line.split(":");
                if (fields.length > 1 && fields[0].equals("Porta")) port = Integer.parseInt(fields[1].replace(" ", ""));
                if (fields.length > 1 && fields[0].equals("Servidor")) server = fields[1].replace(" ", "");
                line = fileReader.readLine();
            }

            file.close();

            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Não foi possível carregar as configurações!");
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Não foi possível carregar as configurações!");
            return false;
        }
    }

    public void run() {
        if (loadConfig()) {
            scn = new Scanner(System.in);

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
                    System.out.println("------------------------------------------\n");
                    command = scn.nextLine();

                    if (command.equals("Exit")) {
                        Thread.sleep(5000);
                        response.stop();
                        socket.close();
                        break;
                    } else {
                        if (validation(command)) {
                            outputStream.flush();
                            outputStream.writeObject(command);
                            Thread.sleep(1000);
                        } else System.out.println("\nComando inválido!");
                    }
                }
                System.out.println("\nConexão encerrada!");
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
