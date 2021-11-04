package com.shubhi.booking.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shubhi.booking.services.DateService;

@RestController
public class DateRestController {

	@Autowired
	DateService dateService;

	@GetMapping(value = "dates")
	public ResponseEntity<List<String>> getDates() {
		return new ResponseEntity<List<String>>(dateService.getDates(), HttpStatus.OK);
	}
}
