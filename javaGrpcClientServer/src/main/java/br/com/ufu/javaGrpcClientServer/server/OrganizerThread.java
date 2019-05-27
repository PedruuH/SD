package br.com.ufu.javaGrpcClientServer.server;

import java.util.concurrent.BlockingQueue;

import br.com.ufu.javaGrpcClientServer.resources.Input;

public class OrganizerThread implements Runnable {
	private BlockingQueue<Input> receptinQueue;
	private Input input;
	
	public OrganizerThread(BlockingQueue<Input> _receptinQueue) {
		this.receptinQueue = _receptinQueue;		
	}

	public void run() {
		while(true) {
			try {
				input = receptinQueue.take();
				input.getEventSource().reply("Ok");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}	
}
