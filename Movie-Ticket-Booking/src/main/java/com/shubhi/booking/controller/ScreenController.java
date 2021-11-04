package com.shubhi.booking.controller;

import javax.servlet.http.HttpSession;

import com.shubhi.booking.dto.ScreenDTO;
import com.shubhi.booking.exceptions.NoScreenAvailableException;
import com.shubhi.booking.rest.client.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ScreenController {

	private static final String THEATER_ID = "theaterId";
	private static final String MOVIE_ID = "movieId";
	private static final String VIEW_NAME = "Time";
	private static final String DATE = "date";
	private static final String SCREEN = "screen";

	@Autowired
    RestClient client;

	@GetMapping("/screen")
	public ModelAndView getScreenService(@RequestParam String date, HttpSession session)
			throws NoScreenAvailableException {

		ResponseEntity<ScreenDTO> response = client.getScreenTimesFromRestClient((int) session.getAttribute(MOVIE_ID),
				(int) session.getAttribute(THEATER_ID));

		if (response.getStatusCode() == HttpStatus.NO_CONTENT)
			throw new NoScreenAvailableException("Screen not found..............");

		ModelAndView modelView = new ModelAndView();
		session.setAttribute("theater", session.getAttribute("theater") );
		session.setAttribute(SCREEN, response.getBody().getScreenId());
		session.setAttribute(DATE, date);
		modelView.setViewName(VIEW_NAME);

		return modelView;

	}

}
