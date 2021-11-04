package com.shubhi.booking.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.shubhi.booking.dto.ScreenDTO;
import com.shubhi.booking.exceptions.NoScreenAvailableException;
import com.shubhi.booking.services.ScreenService;

@RestController
public class ScreenRestController {

	@Autowired
	ScreenService screenService;

	@GetMapping(value = "screen/{movieId}/{theaterId}")
	public ResponseEntity<ScreenDTO> getScreen(@PathVariable int movieId, @PathVariable int theaterId) throws NoScreenAvailableException {

		ScreenDTO screen = screenService.getScreenTimes(movieId, theaterId);
		if (screen == null)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<ScreenDTO>(screen, HttpStatus.OK);
	}

}
