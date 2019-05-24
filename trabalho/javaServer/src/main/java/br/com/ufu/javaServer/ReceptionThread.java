package br.com.ufu.javaServer;

import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import br.com.ufu.javaServer.services.ReceptionServiceImpl;
import br.com.ufu.javaServer.resources.Input;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class ReceptionThread implements Runnable {
	private int port;
	private BlockingQueue<Input> queue = new LinkedBlockingQueue<Input>();
	
	public ReceptionThread(int _port, BlockingQueue<Input> _queue) {
        this.port = _port;
        this.queue = _queue;
    }
	
	public void run() {
		Server server = ServerBuilder.forPort(port)
				.addService(new ReceptionServiceImpl(queue)).build();
		 
		try {
			server.start();
			server.awaitTermination();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		        
	}	
}