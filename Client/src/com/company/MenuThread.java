package com.company;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class MenuThread implements Runnable {
    private Socket socket;
	private Scanner scn;
	private String command;
	ObjectOutputStream outputStream;

    public MenuThread(Socket _socket) {
    	this.socket = _socket;
	}

	public void run() {
		scn = new Scanner(System.in);

		try {
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
					break;
				}
				else {
					if (validation(command)) {
						outputStream.flush();
						outputStream.writeObject(command);
					} else System.out.println("\nComando inválido!");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		scn.close();
	}
    
    public boolean validation(String text) {
		String[] elements = text.split(" ");

		switch(elements[0]) {
			case "Insert":
				if(elements.length < 2) return false;

				break;
			case "Select":
			case "Delete":
				if(elements.length != 2) return false;
				try{
				     Integer.parseInt(elements[1]);
				}catch(NumberFormatException e){
					return false;
				}
				break;
			case "Update":
				if(elements.length < 4 || !elements[2].equals("values")) return false;
				try{
				     Integer.parseInt(elements[1]);
				}catch(NumberFormatException e){
					return false;
				}
				break;
			default:
				return false;
		}
		return true;
	}
}
