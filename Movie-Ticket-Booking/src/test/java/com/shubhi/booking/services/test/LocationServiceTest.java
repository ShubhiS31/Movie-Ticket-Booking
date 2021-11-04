
package com.shubhi.booking.services.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.shubhi.booking.dto.LocationDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.shubhi.booking.dto_mappers.LocationMapper;
import com.shubhi.booking.entity.Location;
import com.shubhi.booking.exceptions.LocationNotFoundException;
import com.shubhi.booking.repository.LocationRepository;
import com.shubhi.booking.services.LocationService;

@SpringBootTest
class LocationServiceTest {

	@MockBean
	LocationRepository locationRepositoryMock;

	@InjectMocks
	LocationService locationServiceMock;

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getLocationsAll() throws LocationNotFoundException {

		List<LocationDTO> locationDTO = new ArrayList<>();
		List<Location> locations = new ArrayList<>();

		when(locationRepositoryMock.findAll()).thenReturn(locations);
		when(LocationMapper.MAPPER.toLocationDTOs(locations)).thenReturn(locationDTO);
		assertEquals(locationDTO, locationServiceMock.getLocations());
	}

	@Test
	public void getLocationsNull() throws LocationNotFoundException {
		when(locationRepositoryMock.findAll()).thenReturn(null);
		when(LocationMapper.MAPPER.toLocationDTOs(null)).thenReturn(null);
		assertEquals(null, locationServiceMock.getLocations());
	}

}
