package com.shubhi.booking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shubhi.booking.entity.Seat;

public interface SeatRepository extends JpaRepository<Seat, String> {

	@Query("select seatNumbers from TicketBooking b where b.theater =?1 AND b.showDate =?2 AND b.showTime =?3 AND b.screen =?4")
	public List<String> getBookedSeatsRepository(String theater, String date, String showTime, int screen);

}
