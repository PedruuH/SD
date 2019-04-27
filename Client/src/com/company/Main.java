package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {
    private static String config = "config.txt";
    private static String server;
    private static int port;

    private static  Socket socket;
    private static InetAddress serverIpAddress;

    public static void main(String[] args) {
        try {
            FileReader file = new FileReader(config);
            BufferedReader fileReader = new BufferedReader(file);

            String line = fileReader.readLine();

            String[] fields;

            while (line != null) {
                fields = line.split(":");
                if(fields.length > 1 && fields[0].equals("Porta")) port = Integer.parseInt(fields[1].replace(" ", ""));
                if(fields.length > 1 && fields[0].equals("Servidor")) server = fields[1].replace(" ", "");
                line = fileReader.readLine();
            }

            file.close();

            serverIpAddress = InetAddress.getByName(server);
            socket = new Socket(serverIpAddress, port);

            Thread menu = new Thread(new MenuThread(socket));
            menu.setDaemon(true);
            menu.start();

            Thread response = new Thread(new ResponseThread(socket));
            response.setDaemon(true);
            response.start();

            menu.join();

            if (!menu.isAlive()) {
                Thread.sleep(5000);
                response.interrupt();
                socket.close();
                System.out.println("Wait is over");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            System.out.println("O endereço IP do servidor é inválido!");
        } catch (IOException e) {
            System.out.println("Ocorreu uma falha!\n" + e);
        }catch(NumberFormatException e){
            System.out.println("Número da porta incorreto! Por favor, verifique o arquivo de configurações.");
        }
    }
}