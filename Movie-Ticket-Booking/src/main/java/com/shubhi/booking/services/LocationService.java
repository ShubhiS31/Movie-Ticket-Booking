package com.shubhi.booking.services;

import java.util.List;

import com.shubhi.booking.dto.LocationDTO;
import com.shubhi.booking.dto_mappers.LocationMapper;
import com.shubhi.booking.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

	@Autowired
    LocationRepository locationRepository;

	public List<LocationDTO> getLocations() {

		return LocationMapper.MAPPER.toLocationDTOs(locationRepository.findAll());
	}

}
