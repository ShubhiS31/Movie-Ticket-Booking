package com.shubhi.booking.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class DateService {

	public List<String> getDates() {
		List<String> dates = new ArrayList<>();
		LocalDate date1 = LocalDate.now();
		dates.add(date1.toString());
		for (int i = 1; i < 7; i++) {
			dates.add(date1.plusDays(i).toString());
		}
		return dates;
	}

}
