package com.shubhi.booking.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.shubhi.booking.dto.TheaterDTO;
import com.shubhi.booking.exceptions.TheaterNotFoundException;
import com.shubhi.booking.rest.client.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TheaterController {

	private static final String SPLITTER = "-";
	private static final String VIEW_NAME = "Theater";
	private static final String LOCATION_ID = "locationId";
	private static final String THEATERS = "theaters";
	private static final String MOVIE = "movie";
	private static final String MOVIE_ID = "movieId";

	@Autowired
    RestClient client;

	@GetMapping("/theater")
	public ModelAndView getTheaterService(@RequestParam String movie, HttpSession session)
			throws TheaterNotFoundException {
		int movieId = Integer.parseInt(movie.split(SPLITTER)[0]);
		String selectedMovie = movie.split(SPLITTER)[1];
		int locationId = (int) session.getAttribute(LOCATION_ID);

		ResponseEntity<List<TheaterDTO>> response = client.getTheatersFromRestClient(locationId, movieId);
		if (response.getStatusCode() == HttpStatus.NO_CONTENT)
			throw new TheaterNotFoundException("OOPS! Theater not found.........");

		ModelAndView modelView = new ModelAndView();
		session.setAttribute(MOVIE_ID, movieId);
		session.setAttribute(MOVIE, selectedMovie);
		modelView.addObject(THEATERS, response.getBody());
		modelView.setViewName(VIEW_NAME);
		return modelView;

	}

}
