package com.shubhi.booking.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shubhi.booking.dto.UserDTO;
import com.shubhi.booking.exceptions.UserNotFoundException;
import com.shubhi.booking.services.UserService;

@RestController
public class UserRestController {
	@Autowired
	UserService userService;

	@GetMapping("/user/{username}")
	public UserDTO getUser(@PathVariable String username) throws UserNotFoundException {
		return userService.getUser(username);

	}

	@PostMapping("/registerNewUser")
	public ResponseEntity<UserDTO> registerNewUser(@RequestBody UserDTO user) {
		boolean isUserPresent = userService.registerUser(user);
		if (isUserPresent) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

}
