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
	
	private static Thread menu;
	private static Thread response;
	
	private ManagedChannel channel;
	private CrudServiceGrpc.CrudServiceBlockingStub stub;
	private BlockingQueue<Object> responseQueue = new LinkedBlockingQueue<Object>();
	
	public JavaClient() {
		channel = ManagedChannelBuilder
	    		.forAddress(serverAddress, port).usePlaintext().build();
		stub = CrudServiceGrpc.newBlockingStub(channel);
	}
	
	@SuppressWarnings("deprecation")
	private void start() throws InterruptedException {
		menu = new Thread(new MenuThread(stub, responseQueue));
		menu.setDaemon(true);

		response = new Thread(new ResponseThread(responseQueue));
		response.setDaemon(true);

		menu.start();
		response.start();
		
		menu.join();
		
		response.join(5000);
		response.stop(); // Verificar essa parte
		
		if (channel != null) {
			channel.shutdown();
			System.out.println("Encerrado");
		}
		
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				System.err.println("O cliente está sendo encerrado");
				JavaClient.this.stop();
				System.err.println("O cliente foi encerrado");				
			}
		});
	}

	private void stop() {
		if (channel != null) {
			channel.shutdown();
		}
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		final JavaClient client = new JavaClient();
		client.start();
	}		
}
