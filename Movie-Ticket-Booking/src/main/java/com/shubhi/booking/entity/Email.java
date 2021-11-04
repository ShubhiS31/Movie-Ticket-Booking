package com.shubhi.booking.entity;

import org.springframework.stereotype.Component;

@Component
public class Email {
	
	String username;
	String selected_date;
	int bookingID;
	String selected_location;
	String selected_movie;
	String selected_theater;
	String selected_seats;
	String selected_time;
	int selected_screen;
	double total_cost;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSelected_date() {
		return selected_date;
	}
	public void setSelected_date(String selected_date) {
		this.selected_date = selected_date;
	}
	public int getBookingID() {
		return bookingID;
	}
	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}
	
	public String getSelected_location() {
		return selected_location;
	}
	public void setSelected_location(String selected_location) {
		this.selected_location = selected_location;
	}
	public String getSelected_movie() {
		return selected_movie;
	}
	public void setSelected_movie(String selected_movie) {
		this.selected_movie = selected_movie;
	}
	public String getSelected_theater() {
		return selected_theater;
	}
	public void setSelected_theater(String selected_theater) {
		this.selected_theater = selected_theater;
	}
	public String getSelected_seats() {
		return selected_seats;
	}
	public void setSelected_seats(String selected_seats) {
		this.selected_seats = selected_seats;
	}
	public int getSelected_screen() {
		return selected_screen;
	}
	public void setSelected_screen(int i) {
		this.selected_screen = i;
	}
	
	public String getSelected_time() {
		return selected_time;
	}
	public void setSelected_time(String selected_time) {
		this.selected_time = selected_time;
	}
	public double getTotal_cost() {
		return total_cost;
	}
	public void setTotal_cost(double d) {
		this.total_cost = d;
	}

	
}
