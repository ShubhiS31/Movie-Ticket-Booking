package com.shubhi.booking.dto;

import lombok.Data;

@Data
public class TheaterDTO {

	private int theaterId;
	private String theaterName;

	public int getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(int theaterId) {
		this.theaterId = theaterId;
	}

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

}
