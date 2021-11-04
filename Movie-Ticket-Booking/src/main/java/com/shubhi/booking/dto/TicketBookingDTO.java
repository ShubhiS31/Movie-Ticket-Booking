package com.shubhi.booking.dto;

import lombok.Data;

@Data
public class TicketBookingDTO {

	private int bookingId;
	private String location;
	private String movie;
	private String theater;
	private String showDate;
	private String showTime;
	private int noOfTickets;
	private int luxuryTickets;
	private int premiumTickets;
	private String seatNumbers;
	private int screen;
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
