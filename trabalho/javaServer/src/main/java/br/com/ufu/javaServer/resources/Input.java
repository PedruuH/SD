package br.com.ufu.javaServer.resources;

public class Input {
	private long id;
    private String content;
    private int operation; // 0 - Insert, 1 - Select, 2 - Update, 3 - Delete;

    public Input(long _id, String _content, int _operation) {
    	this.id = _id;
        this.content = _content;
        this.operation = _operation;
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
}
