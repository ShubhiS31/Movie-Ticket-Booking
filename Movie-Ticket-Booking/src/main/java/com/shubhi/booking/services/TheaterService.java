package com.shubhi.booking.services;

import java.util.List;

import com.shubhi.booking.dto.TheaterDTO;
import com.shubhi.booking.dto_mappers.TheaterMapper;
import com.shubhi.booking.exceptions.TheaterNotFoundException;
import com.shubhi.booking.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TheaterService {

	@Autowired
    TheaterRepository theaterRepository;

	public List<TheaterDTO> getTheaters(int locationId, int movieId) throws TheaterNotFoundException {

		return TheaterMapper.MAPPER.toTheaterDTOs(theaterRepository.getTheatersRepository(locationId, movieId));

	}
}
