
package com.shubhi.booking.services.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.shubhi.booking.dto.ScreenDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.shubhi.booking.dto_mappers.ScreenMapper;
import com.shubhi.booking.entity.Screen;
import com.shubhi.booking.exceptions.NoScreenAvailableException;
import com.shubhi.booking.repository.ScreenRepository;
import com.shubhi.booking.services.ScreenService;

@SpringBootTest
class ScreenServiceTest {

	@MockBean
	ScreenRepository screenRepositoryMock;

	@InjectMocks
	ScreenService screenServiceMock;

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getScreenForJokerAll() throws NoScreenAvailableException {
		Screen screenEntity = new Screen();
		ScreenDTO screenDTO = new ScreenDTO();
		when(screenRepositoryMock.getScreen(Mockito.anyInt(), Mockito.anyInt())).thenReturn(screenEntity);
		when(ScreenMapper.MAPPER.toScreenDTO(screenEntity)).thenReturn(screenDTO);
		assertEquals(screenDTO, screenServiceMock.getScreenTimes(Mockito.anyInt(), Mockito.anyInt()));
	}

	@Test
	public void getScreenForJokerNull() throws NoScreenAvailableException {

		when(screenRepositoryMock.getScreen(Mockito.anyInt(), Mockito.anyInt())).thenReturn(null);
		when(ScreenMapper.MAPPER.toScreenDTO(null)).thenReturn(null);
		assertEquals(null, screenServiceMock.getScreenTimes(Mockito.anyInt(), Mockito.anyInt()));
	}

}
