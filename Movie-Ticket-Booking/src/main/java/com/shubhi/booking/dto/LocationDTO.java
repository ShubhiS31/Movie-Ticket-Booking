package com.shubhi.booking.dto;

import lombok.Data;

@Data
public class LocationDTO {

	private int locationId;

	private String locationName;

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

}
