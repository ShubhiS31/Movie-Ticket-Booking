package com.shubhi.booking.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "mapping")
public class Mapping implements Serializable {

	private static final long serialVersionUID = 746161685101819189L;

	@JoinColumn(name = "LocationID")
	@Column(name = "LocationID")
	private int locationId;

	@JoinColumn(name = "MovieID")
	@Column(name = "MovieID")
	private int movieId;

	@JoinColumn(name = "TheatreID")
	@Column(name = "TheatreID")
	private int theaterId;

	@Id
	@JoinColumn(name = "ScreenID")
	@Column(name = "ScreenID")
	private int screenId;

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(int theaterId) {
		this.theaterId = theaterId;
	}

	public int getScreenId() {
		return screenId;
	}

	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}

}
