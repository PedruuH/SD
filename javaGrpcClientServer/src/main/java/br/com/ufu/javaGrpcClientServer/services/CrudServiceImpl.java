package br.com.ufu.javaGrpcClientServer.services;

import br.com.ufu.javaGrpcClientServer.CrudServiceGrpc.CrudServiceImplBase;

import io.grpc.stub.StreamObserver;

import br.com.ufu.javaGrpcClientServer.InsertRequest;
import br.com.ufu.javaGrpcClientServer.InsertResponse;
import br.com.ufu.javaGrpcClientServer.SelectRequest;
import br.com.ufu.javaGrpcClientServer.SelectResponse;
import br.com.ufu.javaGrpcClientServer.UpdateRequest;
import br.com.ufu.javaGrpcClientServer.UpdateResponse;
import br.com.ufu.javaGrpcClientServer.DeleteRequest;
import br.com.ufu.javaGrpcClientServer.DeleteResponse;

import br.com.ufu.javaGrpcClientServer.resources.Input;
import br.com.ufu.javaGrpcClientServer.resources.EventSource;
import br.com.ufu.javaGrpcClientServer.resources.EventSource.Observer;

import java.util.concurrent.BlockingQueue;

public class CrudServiceImpl extends CrudServiceImplBase {
	// private static final String responseError = "Não foi possível recuperar a resposta para sua solicitação.";
	
	public BlockingQueue<Input> requisitionsQueue;
			
	public CrudServiceImpl(BlockingQueue<Input> _requisitions) {
		this.requisitionsQueue = _requisitions;
	}
	
	@Override
	public void insert(
			InsertRequest request, 
			final StreamObserver<InsertResponse> responseObserver) {
		
		EventSource eventSource = new EventSource();

        eventSource.addObserver(new Observer() {
			@Override
			public void update(final String event) {				
				InsertResponse response = InsertResponse.newBuilder().
						setResponse(event).build(); // Envia a resposta recuperada ou envia a mensagem de erro, caso não encontrada

				responseObserver.onNext(response);
				responseObserver.onCompleted();
			}
		});
        
        Input input = new Input(-1, request.getContent(), 0, eventSource); // Cria a entrada com os dados passados pelo cliente
		
		requisitionsQueue.add(input); // Adiciona a entrada à fila de requisições
	}
	
	/*
	 * @Override public void select( SelectRequest request,
	 * StreamObserver<SelectResponse> responseObserver) {
	 * 
	 * Input input = new Input(request.getId(), null, 1); // Cria a entrada com os
	 * dados passados pelo cliente
	 * 
	 * requisitions.add(input); // Adiciona a entrada à fila de requisições }
	 * 
	 * @Override public void update( UpdateRequest request,
	 * StreamObserver<UpdateResponse> responseObserver) {
	 * 
	 * Input input = new Input(request.getId(), request.getContent(), 2); // Cria a
	 * entrada com os dados passados pelo cliente
	 * 
	 * requisitions.add(input); // Adiciona a entrada à fila de requisições }
	 * 
	 * @Override public void delete( DeleteRequest request,
	 * StreamObserver<DeleteResponse> responseObserver) {
	 * 
	 * Input input = new Input(request.getId(), null, 3); // Cria a entrada com os
	 * dados passados pelo cliente
	 * 
	 * requisitions.add(input); // Adiciona a entrada à fila de requisições }
	 */
}