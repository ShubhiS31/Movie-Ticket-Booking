
package com.shubhi.booking.services.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.shubhi.booking.dto.SeatDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.shubhi.booking.dto_mappers.SeatMapper;
import com.shubhi.booking.entity.Seat;
import com.shubhi.booking.exceptions.NoSeatsFoundException;
import com.shubhi.booking.repository.SeatRepository;
import com.shubhi.booking.services.SeatService;

@SpringBootTest
class SeatServiceTest {

	@MockBean
	SeatRepository seatRepositoryMock;

	@InjectMocks
	SeatService seatServiceMock;

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getBookedSeatsAll() {
		List<String> bookedSeats = Arrays.asList("a1", "a2", "b4", "d1");
		when(seatRepositoryMock.getBookedSeatsRepository(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.anyInt()))
				.thenReturn(bookedSeats);
		assertEquals(bookedSeats,
				seatServiceMock.getBookedSeats(Mockito.any(), Mockito.any(), Mockito.anyString(), Mockito.anyInt()));

	}

	@Test
	public void getBookedSeatsNull() {
		List<String> bookedSeats = new ArrayList<>();
		when(seatRepositoryMock.getBookedSeatsRepository(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(),
				Mockito.anyInt())).thenReturn(bookedSeats);
		assertEquals(bookedSeats, seatServiceMock.getBookedSeats(Mockito.anyString(), Mockito.anyString(),
				Mockito.anyString(), Mockito.anyInt()));
	}

	@Test
	void getTotalSeatsAll() throws NoSeatsFoundException {
		List<SeatDTO> totalSeatsDTO = new ArrayList<>();
		List<Seat> totalSeats = new ArrayList<Seat>();

		when(seatRepositoryMock.findAll()).thenReturn(totalSeats);
		when(SeatMapper.MAPPER.toSeatDTOs(totalSeats)).thenReturn(totalSeatsDTO);
		assertEquals(totalSeatsDTO, seatServiceMock.getTotalSeats());

	}

	@Test
	void getTotalSeatsNull() throws NoSeatsFoundException {
		when(seatRepositoryMock.findAll()).thenReturn(null);
		when(SeatMapper.MAPPER.toSeatDTOs(null)).thenReturn(null);
		assertEquals(null, seatServiceMock.getTotalSeats());

	}

}
