
package com.shubhi.booking.services.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.shubhi.booking.services.DateService;

@SpringBootTest
class DateServiceTest {

	DateService dateServiceMock;

	@BeforeEach
	public void init() {
		dateServiceMock = new DateService();
	}

	@Test
	public void getDatesAll() {
		List<String> dates = new ArrayList<>();
		LocalDateTime currentTime = LocalDateTime.now();
		LocalDate date1 = currentTime.toLocalDate();
		dates.add(date1.toString());
		for (int i = 1; i < 7; i++) {
			dates.add(date1.plusDays(i).toString());
		}
		assertEquals(dates, dateServiceMock.getDates());
	}

}
