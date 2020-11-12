package com.store.mobile.api.exception;

import java.util.List;

import org.springframework.validation.FieldError;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(value=Include.NON_NULL)
public class ErrorResponse {
	private String errorCode;

	private List<FieldError> errors;
	

	public ErrorResponse(String errorCode) {
		this.errorCode = errorCode;
	}

}
