package br.com.ufu.javaGrpcClientServer.client;

import java.io.IOException;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import br.com.ufu.javaGrpcClientServer.CrudServiceGrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class JavaClient {
	private static String serverAddress = "localhost";
	private static int port = 9876;
	
	private static Thread menuThread;
	private static Thread responseThread;
	
	private ManagedChannel channel;
	private CrudServiceGrpc.CrudServiceBlockingStub stub;
	private BlockingQueue<Object> responseQueue = new LinkedBlockingQueue<Object>();
	
	public JavaClient() {
		channel = ManagedChannelBuilder
	    		.forAddress(serverAddress, port).usePlaintext().build();
		stub = CrudServiceGrpc.newBlockingStub(channel);
		
		menuThread = new Thread(new MenuThread(stub, responseQueue));
		menuThread.setDaemon(true);
		
		responseThread = new Thread(new ResponseThread(responseQueue));
		responseThread.setDaemon(true);
	}
	
	private void start() throws InterruptedException {
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {	
				JavaClient.this.stop();							
			}
		});		
		
		menuThread.start();
		responseThread.start();
	}

	@SuppressWarnings("deprecation")
	private void stop() {
		System.err.println("O cliente está sendo encerrado");
		
		if (responseThread.isAlive()) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				System.out.println("Ocorreu uma falha!\n"
						+ "Não foi possível aguardar novas repostas do servidor.");
				e.printStackTrace();
			} finally {
				responseThread.stop();
			}
		}
				
		if (channel != null) {
			channel.shutdown();
		}
		
		System.err.println("O cliente foi encerrado");	
	}
	
	private void blockUntilShutdown() throws InterruptedException {
		menuThread.join();
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		final JavaClient client = new JavaClient();
		client.start();
		client.blockUntilShutdown();
		client.stop();
	}		
}
