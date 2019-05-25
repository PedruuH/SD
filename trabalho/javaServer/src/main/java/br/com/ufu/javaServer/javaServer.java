package br.com.ufu.javaServer;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import br.com.ufu.javaServer.resources.BlockingResponseMap;
import br.com.ufu.javaServer.resources.Input;
import br.com.ufu.javaServer.services.ReceptionServiceImpl;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class javaServer {
	private static int port;
	private static Scanner scn;
	
	public static void main(String[] args) {
		BlockingQueue<Input> queue = new LinkedBlockingQueue<Input>();
		BlockingResponseMap responses = new BlockingResponseMap(10);
		String command;
		
		scn = new Scanner(System.in);
		
		Server ReceptionThread = ServerBuilder.forPort(port)
				.addService(new ReceptionServiceImpl(queue, responses)).build();
		 
		try {
			ReceptionThread.start();
			
			do {
				command = scn.nextLine();
			} while (!command.trim().toLowerCase().equals("exit"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ReceptionThread.shutdown();
		}
	}
}