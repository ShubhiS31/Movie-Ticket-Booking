package com.shubhi.booking.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.shubhi.booking.dto.MovieDTO;
import com.shubhi.booking.exceptions.MovieNotFoundException;
import com.shubhi.booking.services.MovieService;

@RestController
public class MovieRestController {

	@Autowired
	MovieService movieService;

	
	@GetMapping(value = "movie/{locationId}")
	public ResponseEntity<List<MovieDTO>> getMovies(@PathVariable int locationId) throws MovieNotFoundException {
		List<MovieDTO> movies = movieService.getMovies(locationId);
		if (movies.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(movies, HttpStatus.OK);
	}
}
