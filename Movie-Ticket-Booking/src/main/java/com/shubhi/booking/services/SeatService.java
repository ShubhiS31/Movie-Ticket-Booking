package com.shubhi.booking.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

import com.shubhi.booking.dto.SeatDTO;
import com.shubhi.booking.dto_mappers.SeatMapper;
import com.shubhi.booking.exceptions.NoSeatsFoundException;
import com.shubhi.booking.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeatService {

	@Autowired
    SeatRepository seatRepository;

	public List<String> getBookedSeats(String theater, String date, String showTime, int screen) {

		List<String> bookedSeats = seatRepository.getBookedSeatsRepository(theater, date, showTime, screen);
		List<String> seatNumbers = new ArrayList<>();
		Spliterator<String> seatSpliter = bookedSeats.spliterator();
		seatSpliter.forEachRemaining(new Consumer<String>() {
			public void accept(String c) {
				seatNumbers.addAll(Arrays.asList(c.split(",")));
			}
		});

		return seatNumbers;
	}

	public List<SeatDTO> getTotalSeats() throws NoSeatsFoundException {
		return SeatMapper.MAPPER.toSeatDTOs(seatRepository.findAll());
	}

}
