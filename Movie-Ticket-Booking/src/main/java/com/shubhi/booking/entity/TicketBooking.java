package com.shubhi.booking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "ticketbooking")
@Component
public class TicketBooking {
	@Id
	@Column(name = "bookingId")
	private int bookingId;
	@Column(name = "location")
	private String location;
	@Column(name = "movie")
	private String movie;
	@Column(name = "theater")
	private String theater;
	@Column(name = "booked_date")
	private String showDate;
	@Column(name = "booked_time")
	private String showTime;
	@Column(name = "total_tickets")
	private int noOfTickets;
	@Column(name = "luxury_tickets")
	private int luxuryTickets;
	@Column(name = "premium_tickets")
	private int premiumTickets;
	@Column(name = "seat_numbers")
	private String seatNumbers;
	@Column(name = "screen")
	private int screen;
	@Column(name = "total_cost")
	private double totalCost;

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getMovie() {
		return movie;
	}

	public void setMovie(String movie) {
		this.movie = movie;
	}

	public String getTheater() {
		return theater;
	}

	public void setTheater(String theater) {
		this.theater = theater;
	}

	public String getShowDate() {
		return showDate;
	}

	public void setShowDate(String showDate) {
		this.showDate = showDate;
	}

	public String getShowTime() {
		return showTime;
	}

	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}

	public int getNoOfTickets() {
		return noOfTickets;
	}

	public void setNoOfTickets(int noOfTickets) {
		this.noOfTickets = noOfTickets;
	}

	public int getLuxuryTickets() {
		return luxuryTickets;
	}

	public void setLuxuryTickets(int luxuryTickets) {
		this.luxuryTickets = luxuryTickets;
	}

	public int getPremiumTickets() {
		return premiumTickets;
	}

	public void setPremiumTickets(int premiumTickets) {
		this.premiumTickets = premiumTickets;
	}

	public String getSeatNumbers() {
		return seatNumbers;
	}

	public void setSeatNumbers(String seatNumbers) {
		this.seatNumbers = seatNumbers;
	}

	public int getScreen() {
		return screen;
	}

	public void setScreen(int screen) {
		this.screen = screen;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

}
