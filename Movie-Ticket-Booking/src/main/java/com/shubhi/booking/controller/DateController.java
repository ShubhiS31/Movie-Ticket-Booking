package com.shubhi.booking.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.shubhi.booking.exceptions.GenericErrorFoundException;
import com.shubhi.booking.rest.client.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DateController {

	private static final String SPLITTER = "-";
	private static final String VIEW_NAME = "Date";
	private static final String DATES = "dates";
	private static final String THEATER = "theater";
	private static final String THEATER_ID = "theaterId";

	@Autowired
    RestClient client;

	@GetMapping("/date")
	public ModelAndView getDateService(@RequestParam String theater, HttpSession session)
			throws GenericErrorFoundException {

		ResponseEntity<List<String>> response = client.getDatesFromRestClient();

		if (response.getStatusCode() == HttpStatus.BAD_REQUEST)
			throw new GenericErrorFoundException("Internal Server Error...............");

		ModelAndView modelView = new ModelAndView();
		int theaterId = Integer.parseInt(theater.split(SPLITTER)[0]);
		String selectedTheater = theater.split(SPLITTER)[1];
		session.setAttribute(THEATER_ID, theaterId);
		session.setAttribute(THEATER, selectedTheater);
		modelView.addObject(DATES, response.getBody());
		modelView.setViewName(VIEW_NAME);
		return modelView;

	}

}
