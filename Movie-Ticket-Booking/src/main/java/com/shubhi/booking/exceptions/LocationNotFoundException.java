package com.shubhi.booking.exceptions;

public class LocationNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 2183984384421586860L;

	public LocationNotFoundException(String message) {
		super(message);

	}

}
