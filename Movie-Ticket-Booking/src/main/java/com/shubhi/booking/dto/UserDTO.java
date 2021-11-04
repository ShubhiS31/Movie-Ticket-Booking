package com.shubhi.booking.dto;

import lombok.Data;

@Data
public class UserDTO {
	private long ID;
	private String username;
	private String password;
	private String authority;

	public long getId() {
		return ID;
	}

	public void setId(long id) {
		this.ID = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
