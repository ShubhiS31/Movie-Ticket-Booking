package com.shubhi.booking.controller;

import java.util.List;

import com.shubhi.booking.dto.LocationDTO;
import com.shubhi.booking.exceptions.LocationNotFoundException;
import com.shubhi.booking.rest.client.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LocationController {

	private static final String VIEW_NAME = "home";
	private static final String LOCATIONS = "locations";

	@Autowired
    RestClient client;

	@GetMapping("/")
	public ModelAndView getLocationService() throws LocationNotFoundException {

		ResponseEntity<List<LocationDTO>> response = client.getLocationsFromRestClient();

		if (response.getStatusCode() == HttpStatus.NO_CONTENT)
			throw new LocationNotFoundException("Location Not Found");
		ModelAndView modelView = new ModelAndView();
		modelView.addObject(LOCATIONS, response.getBody());
		modelView.setViewName(VIEW_NAME);
		return modelView;
	}

}
