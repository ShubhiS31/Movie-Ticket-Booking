package com.shubhi.booking.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.shubhi.booking.dto.SeatDTO;
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
public class SeatController {

	private static final String VIEW_NAME = "Seat";
	private static final String TOTAL_SEATS = "totalSeats";
	private static final String SCREEN = "screen";
	private static final String DATE = "date";
	private static final String THEATER = "theater";
	private static final String BOOKED_SEATS = "bookedSeats";
	private static final String SHOW_TIME = "showTime";

	@Autowired
    RestClient client;

	@GetMapping("/seat")
	public ModelAndView getSeatService(@RequestParam String time, HttpSession session)
			throws GenericErrorFoundException {

		ResponseEntity<List<String>> seatsResponse = client.getBookedSeatsFromRestClient(
				(String) session.getAttribute(THEATER), (String) session.getAttribute(DATE),
				(String) session.getAttribute(SHOW_TIME), (int) session.getAttribute(SCREEN));

		ResponseEntity<List<SeatDTO>> totalSeatsResponse = client.getTotalSeatsFromRestClient();

		if (seatsResponse.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR)
			throw new GenericErrorFoundException("Internal Server Error...............");

		ModelAndView modelView = new ModelAndView();
		session.setAttribute(SHOW_TIME, time);
		modelView.addObject(BOOKED_SEATS, seatsResponse.getBody());
		modelView.addObject(TOTAL_SEATS, totalSeatsResponse.getBody());
		modelView.setViewName(VIEW_NAME);
		return modelView;

	}
}
