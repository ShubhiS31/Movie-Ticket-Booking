package com.shubhi.booking.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shubhi.booking.dto.TicketBookingDTO;
import com.shubhi.booking.services.TicketBookingService;

@RestController
public class TicketBookingRestController {

	@Autowired
	TicketBookingService ticketBookingService;

	@PostMapping(value = "bookTicket")
	public ResponseEntity<TicketBookingDTO> saveTicketData(@RequestParam String[] seats,
			@RequestBody TicketBookingDTO ticketData) {
		return new ResponseEntity<>(ticketBookingService.saveTicketData(seats, ticketData), HttpStatus.OK);
	}

}