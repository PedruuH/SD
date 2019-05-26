package br.com.ufu.javaGrpcClientServer.services;

import br.com.ufu.javaGrpcClientServer.ReceptionServiceGrpc.ReceptionServiceImplBase;

import io.grpc.stub.StreamObserver;

import br.com.ufu.javaGrpcClientServer.InsertRequest;
import br.com.ufu.javaGrpcClientServer.InsertResponse;
import br.com.ufu.javaGrpcClientServer.SelectRequest;
import br.com.ufu.javaGrpcClientServer.SelectResponse;
import br.com.ufu.javaGrpcClientServer.UpdateRequest;
import br.com.ufu.javaGrpcClientServer.UpdateResponse;
import br.com.ufu.javaGrpcClientServer.resources.BlockingResponseMap;
import br.com.ufu.javaGrpcClientServer.resources.Input;
import br.com.ufu.javaGrpcClientServer.DeleteRequest;
import br.com.ufu.javaGrpcClientServer.DeleteResponse;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

public class ReceptionServiceImpl extends ReceptionServiceImplBase {
	private static final String responseError = "Não foi possível recuperar a resposta para sua solicitação.";
	
	private BigInteger responseId;
	
	public BlockingQueue<Input> requisitionsQueue;
	public BlockingResponseMap responsesMap;
			
	public ReceptionServiceImpl(BlockingQueue<Input> _requisitions, BlockingResponseMap _responses) {
		this.requisitionsQueue = _requisitions;
		this.responsesMap = _responses;
		this.responseId = BigInteger.valueOf(0);
	}
	
	private void setResponseId(BigInteger _responseId) {
		this.responseId = _responseId;
	}
	
	private BigInteger getResponseId() {
		return this.responseId;
	}
	
	@Override
	public void insert(
			InsertRequest request, 
			StreamObserver<InsertResponse> responseObserver) {
		
		BigInteger _responseId;
		
		synchronized(this) {
			_responseId = getResponseId();
			setResponseId(_responseId.add(BigInteger.valueOf(1)));
		}
		
		Input input = new Input(-1, request.getContent(), 0, _responseId); // Cria a entrada com os dados passados pelo cliente
		
		requisitionsQueue.add(input); // Adiciona a entrada à fila de requisições
		
		String responseMessage = "Comando recebido pelo servidor: insert " + request.getContent();
		
		/*try {
			do {
				responseMessage = responsesMap.remove(_responseId); // Recupera a resposta para a requisição na lista de respostas
			} while(responseMessage.equals("null"));
		} catch (InterruptedException e) {
			responseMessage = responseError; // Monta uma mensagem de erro caso ocorra um erro
		}*/
		
		InsertResponse response = InsertResponse.newBuilder().
				setResponse(responseMessage).build(); // Envia a resposta recuperada ou envia a mensagem de erro, caso não encontrada

		responseObserver.onNext(response);
		responseObserver.onCompleted();
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