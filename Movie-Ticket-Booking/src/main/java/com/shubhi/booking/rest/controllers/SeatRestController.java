package com.shubhi.booking.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.shubhi.booking.dto.SeatDTO;
import com.shubhi.booking.exceptions.NoSeatsFoundException;
import com.shubhi.booking.services.SeatService;

@RestController
public class SeatRestController {

	@Autowired
	SeatService seatService;
	

	@GetMapping(value = "seat/{theater}/{date}/{showTime}/{screen}")
	public ResponseEntity<List<String>> getSeat(@PathVariable String theater, @PathVariable String date,
			@PathVariable String showTime, @PathVariable int screen) {
		return new ResponseEntity<List<String>>(seatService.getBookedSeats(theater, date, showTime, screen),
				HttpStatus.OK);
	}

	@GetMapping(value = "totalSeats")
	public ResponseEntity<List<SeatDTO>> getTotalSeats() throws NoSeatsFoundException {
		if (seatService.getTotalSeats().isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<SeatDTO>>(seatService.getTotalSeats(), HttpStatus.OK);
	}

}
