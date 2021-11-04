package com.shubhi.booking.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.shubhi.booking.dto.TheaterDTO;
import com.shubhi.booking.exceptions.TheaterNotFoundException;
import com.shubhi.booking.services.TheaterService;

@RestController
public class TheaterRestController {

	@Autowired
	TheaterService theaterService;

	@GetMapping(value = "theater/{locationId}/{movieId}")
	public ResponseEntity<List<TheaterDTO>> getTheaters(@PathVariable int locationId, @PathVariable int movieId) throws TheaterNotFoundException {

		List<TheaterDTO> theaters = theaterService.getTheaters(locationId, movieId);
		if (theaters.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(theaters, HttpStatus.OK);
	}

}
