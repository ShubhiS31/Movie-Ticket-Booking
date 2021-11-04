package com.shubhi.booking.email_confirmation;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.shubhi.booking.entity.Email;

@Aspect
@Component
public class EmailConfirmationUtils {
	
	@Autowired
	JavaMailSender javamailsender;

	@Autowired
	Email ticket;

	@Pointcut("execution(* com.epam.booking.controller.TicketBookingController.getTicketBookingService(..))")
	public void getTicketBookingService() {
	}

	@After("getTicketBookingService()")
	public void sendMessage() throws AddressException, MessagingException {
		SimpleMailMessage email = new SimpleMailMessage();
		String username = ticket.getUsername();
		String header = "Congratulations " + username + " !!! Your ticket is booked. Here are the details: ";
		String date = "date:" + ticket.getSelected_date();
		String bookingID = "Booking Id:" + ticket.getBookingID();
		String location = "Location :" +ticket.getSelected_location();
		String movie = "Movie:" + ticket.getSelected_movie();
		String theater = "Theater:" + ticket.getSelected_theater();
		String seats = "seat numbers:" + ticket.getSelected_seats();
		String screen = "Screen:" + ticket.getSelected_screen();
		String price = "price:" + ticket.getTotal_cost();
		String footer = "Have a good day............!";
		String textbody = header + "\n" + bookingID + "\n" + date + "\n" + location +"\n"+ movie + "\n" + theater + "\n" + seats + "\n"
				+ screen + "\n" + price + "\n" + footer;
		email.setTo("shubhishukla31@gmail.com");
		email.setFrom("shubhishuklaEPAM@gmail.com");
		email.setSubject("Ticket Confirmation");
		email.setText(textbody);
		javamailsender.send(email);
	}

}
