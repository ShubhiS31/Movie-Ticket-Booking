package com.shubhi.booking.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.shubhi.booking.dto.MovieDTO;
import com.shubhi.booking.exceptions.MovieNotFoundException;
import com.shubhi.booking.rest.client.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MovieController {

	private static final String SPLITTER = "-";
	private static final String VIEW_NAME = "Movie";
	private static final String MOVIES = "movies";
	private static final String LOCATION = "location";
	private static final String LOCATION_ID = "locationId";

	@Autowired
    RestClient client;

	@GetMapping("/Movie")
	public ModelAndView getMovieService(@RequestParam String location, HttpSession session)
			throws MovieNotFoundException {

		int locationId = Integer.parseInt(location.split(SPLITTER)[0]);
		String selectedLocation = location.split(SPLITTER)[1];

		ResponseEntity<List<MovieDTO>> response = client.getMoviesFromRestClient(locationId);
		if (response.getStatusCode() == HttpStatus.NO_CONTENT)
			throw new MovieNotFoundException("OOPS! Movie not found!");

		ModelAndView modelView = new ModelAndView();
		session.setAttribute(LOCATION_ID, locationId);
		modelView.addObject(MOVIES, response.getBody());
		session.setAttribute(LOCATION, selectedLocation);
		modelView.setViewName(VIEW_NAME);
		return modelView;

	}
}
