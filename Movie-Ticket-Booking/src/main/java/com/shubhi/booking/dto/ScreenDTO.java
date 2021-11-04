package com.shubhi.booking.dto;

import lombok.Data;

@Data
public class ScreenDTO {

	private int screenId;

	public int getScreenId() {
		return screenId;
	}

	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}

}
