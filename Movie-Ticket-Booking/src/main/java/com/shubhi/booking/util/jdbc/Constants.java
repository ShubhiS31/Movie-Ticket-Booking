package com.shubhi.booking.util.jdbc;

public class Constants {

	public static final String LOCATION_QUERY = "select l from Location l";
	public static final String MOVIE_QUERY = "select distinct m from Mapping mt inner join Movie m on m.movieId = mt.movieId where mt.locationId =?1";
	public static final String THEATER_QUERY = "select  t from Mapping mt INNER JOIN Theater t ON t.theaterId=mt.theaterId where  mt.locationId=?1 AND mt.movieId=?2";
	public static final String SCREEN_QUERY = "select st from Screen st where screenId=(select screenId from Mapping where movieId=?1  and theaterId=?2)";
	public static final String SEATS_QUERY = "select seatNumbers from TicketBooking b where b.theater =?1 AND b.showDate =?2 AND b.showTime =?3 AND b.screen =?4";
	public static final String TOTAL_SEATS_QUERY = "select ss from Seat ss";
	public static final String BOOKED_TICKET_QUERY = "select bookingId from TicketBooking";
	public static final String URI = "http://localhost:8081/";
}
