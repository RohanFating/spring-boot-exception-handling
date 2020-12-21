package com.myspace.demo.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(value = {ApiRuntimeException.class})
	public ResponseEntity<Object> handleApiRequestException(ApiRuntimeException e, WebRequest wr) {
		ApiException apiException =  new ApiException(e.getMessage(), HttpStatus.BAD_REQUEST,wr.getDescription(false), ZonedDateTime.now(ZoneId.of("Z")));
		return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<Object> handleApiRequestException(Exception e,  WebRequest wr) {
		ApiException apiException =  new ApiException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, wr.getDescription(false), ZonedDateTime.now(ZoneId.of("Z")));
		return new ResponseEntity<>(apiException, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
