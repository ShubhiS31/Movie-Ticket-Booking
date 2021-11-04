package com.shubhi.booking.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import com.shubhi.booking.dto.TicketBookingDTO;
import com.shubhi.booking.rest.client.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shubhi.booking.entity.Email;
import com.shubhi.booking.entity.TicketBooking;

@Controller
public class TicketBookingController {

	private static final String SHOW_TIME = "showTime";
	private static final String SCREEN = "screen";
	private static final String DATE = "date";
	private static final String THEATER = "theater";
	private static final String MOVIE = "movie";
	private static final String LOCATION = "location";
	private static final String SEATS = "seats";
	private static final String VIEW_NAME = "TicketDetails";
	private static final String TICKET_DATA = "data";

	@Autowired
    RestClient client;

	@Autowired
	TicketBooking ticketData;
	
	@Autowired
	Email email;

	@GetMapping("/bookTicket")
	public ModelAndView getTicketBookingService(@RequestParam String[] seat, HttpSession session, Principal principal ) {

		ModelAndView modelView = new ModelAndView();
		String[] seats = seat;
		session.setAttribute(SEATS, seats);

		TicketBookingDTO ticketData = getTicketData(session);

		ResponseEntity<TicketBookingDTO> response = client.saveTicketData(seats, ticketData);
		modelView.addObject(TICKET_DATA, response.getBody());
		modelView.setViewName(VIEW_NAME);
		setMailData(response.getBody(), principal);
		return modelView;

	}

	private TicketBookingDTO getTicketData(HttpSession session) {
		TicketBookingDTO ticketData = new TicketBookingDTO();
		ticketData.setLocation((String) session.getAttribute(LOCATION));
		ticketData.setMovie((String) session.getAttribute(MOVIE));
		ticketData.setTheater((String) session.getAttribute(THEATER));
		ticketData.setShowDate((String) session.getAttribute(DATE));
		ticketData.setScreen((int) session.getAttribute(SCREEN));
		ticketData.setShowTime((String) session.getAttribute(SHOW_TIME));

		return ticketData;

	}
	
	private void setMailData(TicketBookingDTO ticketBookingDTO, Principal principal) {
		email.setUsername(principal.getName());
		email.setBookingID(ticketBookingDTO.getBookingId());
		email.setSelected_date(ticketBookingDTO.getShowDate());
		email.setSelected_theater(ticketBookingDTO.getTheater());
		email.setSelected_movie(ticketBookingDTO.getMovie());
		email.setSelected_location(ticketBookingDTO.getLocation());
		email.setSelected_screen(ticketBookingDTO.getScreen());
		email.setSelected_seats(ticketBookingDTO.getSeatNumbers());
		email.setSelected_time(ticketBookingDTO.getShowTime());
		email.setTotal_cost(ticketBookingDTO.getTotalCost());
	
	

}
}
