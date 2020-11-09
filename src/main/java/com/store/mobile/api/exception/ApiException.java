package com.store.mobile.api.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3069953004727956326L;
	private String message;

	public ApiException(Throwable t) {
		this.message= t.getMessage();
	}
	
	public ApiException(String message) {
		this.message=message;
	}
}
