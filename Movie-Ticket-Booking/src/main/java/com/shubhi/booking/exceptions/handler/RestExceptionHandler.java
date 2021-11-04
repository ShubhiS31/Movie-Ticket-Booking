package com.shubhi.booking.exceptions.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.shubhi.booking.exceptions.GenericErrorFoundException;
import com.shubhi.booking.exceptions.LocationNotFoundException;
import com.shubhi.booking.exceptions.MovieNotFoundException;
import com.shubhi.booking.exceptions.NoScreenAvailableException;
import com.shubhi.booking.exceptions.NoSeatsFoundException;
import com.shubhi.booking.exceptions.TheaterNotFoundException;
import com.shubhi.booking.exceptions.UserNotFoundException;

@RestControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler({ UserNotFoundException.class, LocationNotFoundException.class, MovieNotFoundException.class, TheaterNotFoundException.class,
			NoScreenAvailableException.class, NoSeatsFoundException.class})
	public ResponseEntity<Object> errors(Exception exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NO_CONTENT);
	}

	@ExceptionHandler(GenericErrorFoundException.class)
	public ResponseEntity<Object> generalError(Exception exception) {
		return new ResponseEntity<Object>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}

}
