package com.shubhi.booking.controller;

import com.shubhi.booking.dto.UserDTO;
import com.shubhi.booking.rest.client.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	private static final String USER_AUTHORITY = "USER";
	private static final String MESSAGE = "message";
	private static final String USER_EXISTS_MSG = "Username already exist! Please try with another name";
	private static final String LOGIN_SUCCESS_MSG = "Registered Successfully! Login to book ticket";
	private static final String VIEW_NAME = "register";
	@Autowired
    RestClient restClient;

	@RequestMapping("/")
	public String home() {
		return "home";
	}

	@RequestMapping("/login")
	public String loginPage() {
		return "login";
	}

	@PostMapping("/logout-success")
	public String logoutPage() {
		return "Logout";
	}

	@GetMapping("/register")
	public String register() {
		return VIEW_NAME;
	}

	@PostMapping("/registerUser")
	public ModelAndView newUserRegister(@RequestParam String username, @RequestParam String password) {
		ModelAndView modelView = new ModelAndView();
		UserDTO user = new UserDTO();
		user.setUsername(username);
		user.setPassword(password);
		user.setAuthority(USER_AUTHORITY);
		ResponseEntity<UserDTO> response = restClient.registerUser(user);
		if (response.getStatusCode() == HttpStatus.OK) {
			modelView.addObject(MESSAGE, LOGIN_SUCCESS_MSG);
		} else {
			modelView.addObject(MESSAGE, USER_EXISTS_MSG);
		}
		modelView.setViewName(VIEW_NAME);
		return modelView;

	}

}
