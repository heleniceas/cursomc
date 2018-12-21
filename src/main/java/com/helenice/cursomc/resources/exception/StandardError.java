package com.helenice.cursomc.resources.exception;

import java.io.Serializable;

public class StandardError implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer status;
	private String msg;
	private Long timeStampp;
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Long getTimeStampp() {
		return timeStampp;
	}
	public void setTimeStampp(Long timeStampp) {
		this.timeStampp = timeStampp;
	}
	
	public StandardError(Integer status, String msg, Long timeStampp) {
		super();
		this.status = status;
		this.msg = msg;
		this.timeStampp = timeStampp;
	}
	
	public StandardError() {
		super();
	}

	
	
	
}
