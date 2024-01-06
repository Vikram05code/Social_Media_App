package com.vikram.response;

public class ApiResponse { 

	private String msgs;
	private boolean status;
	
	public ApiResponse() {
		
	}
	
	
	public ApiResponse(String msgs, boolean status) {
		super();
		this.msgs = msgs;
		this.status = status;
	}


	public String getMsgs() {
		return msgs;
	}


	public void setMsgs(String msgs) {
		this.msgs = msgs;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
	
}
