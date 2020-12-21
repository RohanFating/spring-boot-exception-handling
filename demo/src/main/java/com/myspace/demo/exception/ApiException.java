package com.myspace.demo.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

public class ApiException {

	private final String message;
	private final HttpStatus status;
	private final String details;
	private final ZonedDateTime zt;
	
	public ApiException(String message, HttpStatus status, String details, ZonedDateTime zt) {
		this.message = message;
		this.status = status;
		this.details = details;
		this.zt = zt;
	}

	public String getDetails() {
		return details;
	}

	public String getMessage() {
		return message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public ZonedDateTime getZt() {
		return zt;
	}
	
	
}
