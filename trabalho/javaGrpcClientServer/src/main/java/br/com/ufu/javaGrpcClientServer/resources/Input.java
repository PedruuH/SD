package br.com.ufu.javaGrpcClientServer.resources;

import java.math.BigInteger;

public class Input {
	private long id;
    private String content;
    private int operation; // 0 - Insert, 1 - Select, 2 - Update, 3 - Delete;
    private BigInteger responseId;

    public Input(long _id, String _content, int _operation, BigInteger _responseId) {
    	this.id = _id;
        this.content = _content;
        this.operation = _operation;
        this.responseId = _responseId;
    }
    
    public void setId(long _id) {
    	this.id = _id;
    }
    
    public long getId() {
    	return this.id;
    }

    public void setContent(String _content) {
        this.content = _content;
    }

    public String getContent() {
        return this.content;
    }
    
    public void setOperation(int _operation) {
    	this.operation = _operation;
    }
    
    public int getOperation() {
    	return this.operation;
    }
    
    public void setResponseId(BigInteger _responseId) {
    	this.responseId = _responseId;
    }
    
    public BigInteger getResponseId() {
    	return this.responseId;
    }
}
