package br.com.ufu.javaGrpcClientServer.client;

import br.com.ufu.javaGrpcClientServer.InsertRequest;
import br.com.ufu.javaGrpcClientServer.InsertResponse;
import br.com.ufu.javaGrpcClientServer.ReceptionServiceGrpc;
import br.com.ufu.javaGrpcClientServer.ReceptionServiceGrpc.ReceptionServiceBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class JavaClient {
	private static String serverAddress = "localhost";
	private static int port = 9876;
	
	public static void main(String[] args) throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder
        		.forAddress(serverAddress, port).usePlaintext().build();

        ReceptionServiceGrpc.ReceptionServiceBlockingStub stub 
          = ReceptionServiceGrpc.newBlockingStub(channel);

        InsertResponse insertResponse = stub.insert(InsertRequest.newBuilder().setContent("teste").build());

        System.out.println("Response received from server:\n" + insertResponse);

        channel.shutdown();
    }
}
