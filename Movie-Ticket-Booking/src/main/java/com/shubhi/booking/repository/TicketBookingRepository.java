package com.shubhi.booking.repository;

import java.util.List;

import com.shubhi.booking.entity.TicketBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface TicketBookingRepository extends JpaRepository<TicketBooking, Integer> {

	@Query("select bookingId from TicketBooking")
	public List<String> getBookingId();

}
