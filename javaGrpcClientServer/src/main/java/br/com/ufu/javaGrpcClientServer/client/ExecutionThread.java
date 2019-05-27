package br.com.ufu.javaGrpcClientServer.client;

import java.util.HashMap;
import java.util.concurrent.BlockingQueue;

import br.com.ufu.javaGrpcClientServer.resources.Input;

public class ExecutionThread implements Runnable {
	private BlockingQueue<Input> executionQueue;
	private static HashMap<Long, byte[]> dataBase = new HashMap<Long, byte[]>();
	private long nextKey = 0;
	private Input input;
	
	public ExecutionThread(BlockingQueue<Input> _executionQueue) {
		this.executionQueue = _executionQueue;
	}
	
	public void run() {
		try {
			while (true) {
				if (!executionQueue.isEmpty()) {
					input = executionQueue.take();
					switch (input.getOperation()) {
					case 0:
						dataBase.put(nextKey++, input.getContent().getBytes());
						input.getEventSource().reply("OK");
						break;
					case 1:
						if (input.getContent().compareTo("*") == 0) {
							String response = "";
							for (HashMap.Entry<Long, byte[]> pair : dataBase.entrySet()) {
								response += pair.getKey().toString() + " " + new String(pair.getValue()) + System.getProperty("line.separator");
							}
							input.getEventSource().reply(response);
						} else if (dataBase.containsKey(input.getId())) {
							input.getEventSource().reply(input.getId() + " " + new String(dataBase.get(input.getId())));
						} else {
							input.getEventSource().reply("NOK");
						}
						break;
					case 2:
						if (dataBase.containsKey(input.getId())) {
							dataBase.replace(input.getId(), input.getContent().getBytes());
							input.getEventSource().reply("OK");
						} else {
							input.getEventSource().reply("NOK");
						}
						break;
					case 3:						
						if (dataBase.containsKey(input.getId())) {
							dataBase.remove(input.getId());
							input.getEventSource().reply("OK");
						} else {
							input.getEventSource().reply("NOK");
						}
						break;

					default:
						input.getEventSource().reply("NOK");
						break;
					}
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
