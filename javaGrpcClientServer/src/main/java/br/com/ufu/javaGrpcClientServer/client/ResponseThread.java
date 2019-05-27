package br.com.ufu.javaGrpcClientServer.client;

import java.util.concurrent.BlockingQueue;

public class ResponseThread implements Runnable {
	private BlockingQueue<Object> responseQueue;
	
	public ResponseThread(BlockingQueue<Object> _responseQueue) {
		this.responseQueue = _responseQueue;
	}
	
    public void run() {
		while (true) {
			try {
				if (!responseQueue.isEmpty())
					System.out.println("Resposta: " + responseQueue.take());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    }
}
