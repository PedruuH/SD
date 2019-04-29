package br.ufu.sd;

import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;

public class MenuThread implements Runnable {
	private Scanner scn;
	ObjectOutputStream outputStream;

	public MenuThread(ObjectOutputStream _outputStream) {
		this.outputStream = _outputStream;
	}

	public void run() {
		scn = new Scanner(System.in);
		while (true) {
			System.out.println("\n----------- Lista de Comandos ------------");
			System.out.println("1. Insert <value>");
			System.out.println("2. Select <id>");
			System.out.println("3. Update <id> value <value>");
			System.out.println("4. Delete <id>");
			System.out.println("5. Exit");
			System.out.println("------------------------------------------");
			String command = scn.nextLine();

			if (command.toLowerCase().equals("exit")) {
				break;
			} else {
				if (ValidateCommand(command)) {
					try {
						outputStream.flush();
						outputStream.writeObject(command);
						Thread.sleep(1000);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else
					System.out.println("\nComando inválido!");
			}
		}
		scn.close();
	}

	public boolean ValidateCommand(String text) {
		char c;
		String cmd = "";
		String[] elements;

		for (int i = 0; i < text.length(); i++) {
			c = text.charAt(i);
			if (c == ' ') break;
			cmd += c;
		}

		switch (cmd.toLowerCase()) {
			case "insert":
				if (text.replace(cmd, "").trim().compareTo("") == 0)
					return false;
				break;
			case "select":
				elements = text.split(" ");
				if (elements.length < 2)
					return false;
				if (elements[1].trim().compareTo("*") != 0) {
					try {
						BigInteger b = new BigInteger(elements[1]);
					} catch (NumberFormatException e) {
						return false;
					}
				}
				break;
			case "delete":
				elements = text.split(" ");
				if (elements.length < 2)
					return false;
				try {
					BigInteger b = new BigInteger(elements[1]);
				} catch (NumberFormatException e) {
					return false;
				}
				break;
			case "update":
				elements = text.split("(?i)value");
				if (elements.length < 2)
					return false;
				elements = elements[0].split(" ");
				if (elements.length < 2)
					return false;
				try {
					BigInteger b = new BigInteger(elements[1]);
				} catch (NumberFormatException e) {
					return false;
				}
				break;
			default:
				return false;
		}
		return true;
	}
}
