package com.abc.travel.exception;

public class InvalidInputException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidInputException(String errMsg) {
		super(errMsg);
	}

}
