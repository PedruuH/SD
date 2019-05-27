package br.com.ufu.javaGrpcClientServer.server;

import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import br.com.ufu.javaGrpcClientServer.client.ExecutionThread;
import br.com.ufu.javaGrpcClientServer.resources.Input;
import br.com.ufu.javaGrpcClientServer.services.CrudServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class JavaServer {
	private static int port;
	
	private Thread organizerThread;
	private Thread executionThread;
	
	private BlockingQueue<Input> receptionQueue;	
	private BlockingQueue<Input> executionQueue;
	private BlockingQueue<Input> logQueue;
	private BlockingQueue<Input> repassQueue;
		
	private Server receptionThread;
	
	public JavaServer() {
		receptionQueue = new LinkedBlockingQueue<Input>();	
		executionQueue = new LinkedBlockingQueue<Input>();
		logQueue = new LinkedBlockingQueue<Input>();
		repassQueue = new LinkedBlockingQueue<Input>();
		
		organizerThread = new Thread(
				new OrganizerThread(receptionQueue, executionQueue, logQueue, repassQueue));
		executionThread = new Thread(
				new ExecutionThread(executionQueue));
	}

	private void start() throws IOException {
		port = 9876;
		
		organizerThread.setDaemon(true);
		organizerThread.start();
		
		executionThread.setDaemon(true);
		executionThread.start();
		
		receptionThread = ServerBuilder.forPort(port).addService(
				new CrudServiceImpl(receptionQueue)).build().start();
		
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