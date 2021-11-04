
package com.shubhi.booking.services.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.shubhi.booking.dto.TheaterDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.shubhi.booking.dto_mappers.TheaterMapper;
import com.shubhi.booking.entity.Theater;
import com.shubhi.booking.exceptions.TheaterNotFoundException;
import com.shubhi.booking.repository.TheaterRepository;
import com.shubhi.booking.services.TheaterService;

@SpringBootTest
class TheaterServiceTest {

	@MockBean
	TheaterRepository theaterRepositoryMock;

	@InjectMocks
	TheaterService theaterServiceMock;

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getTheatersForJokerAll() throws TheaterNotFoundException {

		List<TheaterDTO> theaterDTO = new ArrayList<>();
		List<Theater> theaters = new ArrayList<>();
		when(theaterRepositoryMock.getTheatersRepository(Mockito.anyInt(), Mockito.anyInt())).thenReturn(theaters);
		when(TheaterMapper.MAPPER
				.toTheaterDTOs(theaterRepositoryMock.getTheatersRepository(Mockito.anyInt(), Mockito.anyInt())))
						.thenReturn(theaterDTO);
		assertEquals(theaterDTO, theaterServiceMock.getTheaters(Mockito.anyInt(), Mockito.anyInt()));
	}

	@Test
	public void getTheatersForJokerNull() throws TheaterNotFoundException {
		when(theaterRepositoryMock.getTheatersRepository(Mockito.anyInt(), Mockito.anyInt())).thenReturn(null);
		when(TheaterMapper.MAPPER
				.toTheaterDTOs(theaterRepositoryMock.getTheatersRepository(Mockito.anyInt(), Mockito.anyInt())))
						.thenReturn(null);
		assertEquals(null, theaterServiceMock.getTheaters(Mockito.anyInt(), Mockito.anyInt()));
	}

}
