package com.shubhi.booking.rest.client;

import java.util.List;
import java.util.Optional;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.shubhi.booking.dto.LocationDTO;
import com.shubhi.booking.dto.MovieDTO;
import com.shubhi.booking.dto.ScreenDTO;
import com.shubhi.booking.dto.SeatDTO;
import com.shubhi.booking.dto.TheaterDTO;
import com.shubhi.booking.dto.TicketBookingDTO;
import com.shubhi.booking.dto.UserDTO;

@Service
public class RestClient {

	private static final String REGISTER_NEW_USER = "registerNewUser";
	static final String SPLITTER = "/";
	static final String LOCATION = "locations";
	static final String THEATER = "theater";
	static final String MOVIE = "movie";
	static final String DATES = "dates";
	static final String SCREEN = "screen";
	static final String SEAT = "seat";
	static final String TOTAL_SEATS = "totalSeats";
	static final String BOOK_TICKET = "bookTicket";
	static final String USER = "user";
	static final String URI = "http://localhost:8081/";

	RestTemplate rest = new RestTemplate();

	public ResponseEntity<Optional<UserDTO>> getUser(String username) {
		return rest.exchange(URI + SPLITTER + USER + SPLITTER + username, HttpMethod.GET, null,
				new ParameterizedTypeReference<Optional<UserDTO>>() {
				});
	}

	public ResponseEntity<UserDTO> registerUser(UserDTO user) {
		return rest.postForEntity(URI + SPLITTER + REGISTER_NEW_USER, user, UserDTO.class);
	}

	public ResponseEntity<List<LocationDTO>> getLocationsFromRestClient() {
		return rest.exchange(URI + LOCATION, HttpMethod.GET, null, new ParameterizedTypeReference<List<LocationDTO>>() {
		});

	}

	public ResponseEntity<List<MovieDTO>> getMoviesFromRestClient(int locationId) {
		return rest.exchange(URI + MOVIE + SPLITTER + locationId, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<MovieDTO>>() {
				});
	}

	public ResponseEntity<List<TheaterDTO>> getTheatersFromRestClient(int locationId, int movieId) {
		return rest.exchange(URI + THEATER + SPLITTER + locationId + SPLITTER + movieId, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<TheaterDTO>>() {
				});

	}

	public ResponseEntity<List<String>> getDatesFromRestClient() {
		return rest.exchange(URI + DATES, HttpMethod.GET, null, new ParameterizedTypeReference<List<String>>() {
		});

	}

	public ResponseEntity<ScreenDTO> getScreenTimesFromRestClient(int movieId, int theaterId) {
		return rest.exchange(URI + SCREEN + SPLITTER + movieId + SPLITTER + theaterId, HttpMethod.GET, null,
				new ParameterizedTypeReference<ScreenDTO>() {
				});
	}

	public ResponseEntity<List<String>> getBookedSeatsFromRestClient(String theater, String date, String showTime,
			int screen) {
		return rest.exchange(
				URI + SEAT + SPLITTER + theater + SPLITTER + date + SPLITTER + showTime + SPLITTER + screen,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<String>>() {
				});
	}

	public ResponseEntity<List<SeatDTO>> getTotalSeatsFromRestClient() {
		return rest.exchange(URI + TOTAL_SEATS, HttpMethod.GET, null, new ParameterizedTypeReference<List<SeatDTO>>() {
		});
	}

	public ResponseEntity<TicketBookingDTO> saveTicketData(String[] seats, TicketBookingDTO ticketData) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URI + BOOK_TICKET);
		for (String item : seats) {
			builder.queryParam("seats", item);
		}
		return rest.postForEntity(builder.build().encode().toUri(), ticketData, TicketBookingDTO.class);
	}

}
