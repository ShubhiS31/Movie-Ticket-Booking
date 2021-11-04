package com.shubhi.booking.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * The Class ValidateLogin.
 *
 * @author Shubhi_Shukla
 *
 */
@Controller
public class LoginController {

	private static final String ERROR_MESSAGE_ATTRIBUTE = "errorMessage";
	private static final String WRONG_CREDENTIALS_MSG = "Please enter correct credentials";
	private static final String USER_ID = "userid";
	private static final String PASSWORD = "1234";
	private static final String USERNAME = "shubhi";

	@RequestMapping("/Login")
	public void validateUser(@RequestParam String userId, @RequestParam String password, HttpSession session,
			HttpServletResponse response) throws IOException {

		if (userId.equals(USERNAME) && password.equals(PASSWORD)) {

			session.setAttribute(USER_ID, userId);
			response.sendRedirect("location");
		}

		else {
			session.setAttribute(ERROR_MESSAGE_ATTRIBUTE, WRONG_CREDENTIALS_MSG);
		}
	}

}
