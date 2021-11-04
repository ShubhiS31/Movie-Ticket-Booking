package com.shubhi.booking.services;

import java.util.List;
import java.util.Random;

import com.shubhi.booking.dto.TicketBookingDTO;
import com.shubhi.booking.dto_mappers.TicketBookingMapper;
import com.shubhi.booking.repository.TicketBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketBookingService {

	static final String CLASS_A = "a";
	static final String CLASS_B = "b";
	static final String CLASS_C = "c";

	@Autowired
    TicketBookingRepository bookingRepository;

	private static final int PREMIUM = 150;
	private static final int LUXURY = 100;
	int luxuryTickets;
	int premiumTickets;

	private TicketBookingService() {
		luxuryTickets = 0;
		premiumTickets = 0;
	}

	private void seatSelection(String[] seats, TicketBookingDTO ticketData) {
		String selectedSeats = "";
		int noOfTickets = seats.length;
		for (int i = 0; i < noOfTickets; i++) {
			selectedSeats += seats[i] + ",";
			checkType(seats[i]);
		}
		ticketData.setNoOfTickets(noOfTickets);
		ticketData.setLuxuryTickets(luxuryTickets);
		ticketData.setPremiumTickets(premiumTickets);
		ticketData.setSeatNumbers(selectedSeats);
		luxuryTickets = 0;
		premiumTickets = 0;
	}

	private void checkType(String seatNumber) {
		if (seatNumber.substring(0, 1).equals(CLASS_A) || seatNumber.substring(0, 1).equals(CLASS_B)
				|| seatNumber.substring(0, 1).equals(CLASS_C)) {
			luxuryTickets++;
		} else {
			premiumTickets++;
		}
	}

	private void totalAmount(TicketBookingDTO ticketData) {

		double cost = ((double) ticketData.getPremiumTickets() * PREMIUM) + (ticketData.getLuxuryTickets() * LUXURY);
		double gst = cost * .18;
		ticketData.setTotalCost(cost + gst);
	}

	public TicketBookingDTO saveTicketData(String[] seats, TicketBookingDTO ticketData) {
		seatSelection(seats, ticketData);
		List<String> bookingIdList = bookingRepository.getBookingId();
		int bookingId = generateBookingId();
		while (bookingIdList.contains(bookingId)) {
			bookingId = generateBookingId();
		}
		ticketData.setBookingId(bookingId);
		totalAmount(ticketData);
		bookingRepository.save(TicketBookingMapper.MAPPER.toTicketBooking(ticketData));
		return ticketData;
	}

	public int generateBookingId() {
		Random randomNumber = new Random();
		return (100000 + randomNumber.nextInt(900000));
	}

}
