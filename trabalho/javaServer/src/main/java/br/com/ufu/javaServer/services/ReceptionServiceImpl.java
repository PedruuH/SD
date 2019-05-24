package br.com.ufu.javaServer.services;

import br.com.ufu.javaServer.ReceptionServiceGrpc.ReceptionServiceImplBase;

import io.grpc.stub.StreamObserver;

import br.com.ufu.javaServer.InsertRequest;
import br.com.ufu.javaServer.InsertResponse;

import br.com.ufu.javaServer.resources.Input;

import java.util.concurrent.BlockingQueue;

public class ReceptionServiceImpl extends ReceptionServiceImplBase {
	public BlockingQueue<Input> queue;
		
	public ReceptionServiceImpl(BlockingQueue<Input> _queue) {
		this.queue = _queue;
	}
	
	@Override
	public void insert(
			InsertRequest request, 
			StreamObserver<InsertResponse> responseObserver) {
		Input input = new Input(-1, request.getContent(), 0);
		
		queue.add(input);
	}
}