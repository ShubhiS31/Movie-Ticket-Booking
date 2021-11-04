
package com.shubhi.booking.services.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import com.shubhi.booking.dto.TicketBookingDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.shubhi.booking.dto_mappers.TicketBookingMapper;
import com.shubhi.booking.entity.TicketBooking;
import com.shubhi.booking.repository.TicketBookingRepository;
import com.shubhi.booking.services.TicketBookingService;

@SpringBootTest
class TicketBookingServiceTest {

	@MockBean
	TicketBookingRepository bookTicketRepositoryMock;

	@InjectMocks
	TicketBookingService bookTicketServiceMock;

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void saveTicketDataSuccessWithRandomId() {
		List<String> bookingIds = Arrays.asList("123456", "234567", "987654");
		String seats[] = { "a1", "b1", "c1", "d1", "g1" };
		TicketBookingDTO ticketData = new TicketBookingDTO();
		TicketBooking ticket = new TicketBooking();
		when(bookTicketRepositoryMock.getBookingId()).thenReturn(bookingIds);
		when(TicketBookingMapper.MAPPER.toTicketBookingDTO(ticket)).thenReturn(ticketData);
		assertEquals(bookTicketServiceMock.saveTicketData(seats, ticketData), ticketData);

	}

	@Test
	void saveTicketDataFailToSubmit() {
		List<String> bookingIds = Arrays.asList("123456", "234567", "987654");
		String seats[] = {};
		TicketBookingDTO ticketData = new TicketBookingDTO();
		when(bookTicketRepositoryMock.getBookingId()).thenReturn(bookingIds);
		when(TicketBookingMapper.MAPPER.toTicketBookingDTO(null)).thenReturn(null);
		assertEquals(bookTicketServiceMock.saveTicketData(seats, ticketData), ticketData);

	}

}
