package com.shubhi.booking.services;

import com.shubhi.booking.dto.ScreenDTO;
import com.shubhi.booking.dto_mappers.ScreenMapper;
import com.shubhi.booking.exceptions.NoScreenAvailableException;
import com.shubhi.booking.repository.ScreenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScreenService {

	@Autowired
    ScreenRepository screenRepository;

	public ScreenDTO getScreenTimes(int movieId, int theaterId) throws NoScreenAvailableException {
		return ScreenMapper.MAPPER.toScreenDTO(screenRepository.getScreen(movieId, theaterId));
	}

}
