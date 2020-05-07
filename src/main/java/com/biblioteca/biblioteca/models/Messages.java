package com.biblioteca.biblioteca.models;

public class Messages {
	private String msg;
	private Boolean status;
	public Messages(String message) {
			this.msg = message;
	}
	public void setStatus(Boolean st) {
		this.status = st;
	}
	public Boolean getStatus() {
		return this.status;
	}
	public String getMsg() {
		return this.msg;
	}
	
	
}
