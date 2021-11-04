package com.shubhi.booking.exceptions;

public class NoSeatsFoundException extends Exception {
	
	
	private static final long serialVersionUID = 1906658739646158011L;

	public NoSeatsFoundException(String message) {
		super(message);
	}

}
