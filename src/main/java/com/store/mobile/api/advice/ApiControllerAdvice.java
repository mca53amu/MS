package com.store.mobile.api.advice;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.store.mobile.api.constants.Constants;
import com.store.mobile.api.exception.ApiException;
import com.store.mobile.api.exception.ErrorResponse;
import com.store.mobile.api.exception.NotFoundException;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestControllerAdvice
public class ApiControllerAdvice extends ResponseEntityExceptionHandler {
	private static final Logger LOGGER = LoggerFactory.getLogger(ApiControllerAdvice.class);
	@Autowired
	private HttpServletRequest request;

	@ExceptionHandler(ApiException.class)
	public ResponseEntity<ErrorResponse> apiException(ApiException e) {

		logDetails(e);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse(e.getMessage(), null));
	}

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorResponse> notFoundException(NotFoundException e) {

		logDetails(e);
		LOGGER.error("Fail", e);
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new ErrorResponse(e.getMessage(), request.getAttribute(Constants.LOG_REFERENCE_ID).toString()));
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> generalException(Exception e) {
		logDetails(e);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new ErrorResponse(e.getMessage(), request.getAttribute(Constants.LOG_REFERENCE_ID).toString()));
	}

	private void logDetails(Exception e) {
		log.error( //
				String.format( //
						"API Validation Failed. Fail Message [%s], Description [%s], Log Reference [%s] (%s:%d)", //
						"Error", //
						e.getCause(), //
						request.getAttribute(Constants.LOG_REFERENCE_ID), //
						e.getStackTrace()[0].getFileName(), //
						e.getStackTrace()[0].getLineNumber() //
				) //
		);
	}
}
