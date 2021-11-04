package com.shubhi.booking.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shubhi.booking.dto.LocationDTO;
import com.shubhi.booking.services.LocationService;

@RestController
public class LocationRestController {

	@Autowired
	private LocationService locationService;
  
	@GetMapping(value = "locations")
	public ResponseEntity<List<LocationDTO>> getLocations() {
		List<LocationDTO> locations = locationService.getLocations();
		if (locations.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(locations, HttpStatus.OK);
	}

}
