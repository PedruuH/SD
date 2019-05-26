package br.com.ufu.javaGrpcClientServer.server;

import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import br.com.ufu.javaGrpcClientServer.resources.Input;
import br.com.ufu.javaGrpcClientServer.services.ReceptionServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class JavaServer {
	private static int port;
	
	private BlockingQueue<Input> receptinQueue = new LinkedBlockingQueue<Input>();	
		
	private Server receptionThread;
	
	public JavaServer() {
		Thread organizer = new Thread(new OrganizerThread(receptinQueue));
        organizer.setDaemon(true);
        organizer.start();
	}

	private void start() throws IOException {
		port = 9876;
		
		receptionThread = ServerBuilder.forPort(port).addService(
				new ReceptionServiceImpl(receptinQueue)).build().start();
		
		System.out.println("Servidor ouvindo a porta " + port);
		
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				System.err.println("O servidor gRPC está sendo encerrado");
				JavaServer.this.stop();
				System.err.println("O servidor foi encerrado");
			}
		});
	}

	private void stop() {
		if (receptionThread != null) {
			receptionThread.shutdown();
		}
	}

	private void blockUntilShutdown() throws InterruptedException {
		if (receptionThread != null) {
			receptionThread.awaitTermination();
		}
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		final JavaServer server = new JavaServer();
		server.start();
		server.blockUntilShutdown();
	}
		
}