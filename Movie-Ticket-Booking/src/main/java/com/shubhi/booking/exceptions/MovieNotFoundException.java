package com.shubhi.booking.exceptions;

public class MovieNotFoundException extends Exception {

	private static final long serialVersionUID = 2145701460647778561L;

	public MovieNotFoundException(String message) {
		super(message);
	}

}
