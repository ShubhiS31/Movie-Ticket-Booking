package com.shubhi.booking.services;

import java.util.List;

import com.shubhi.booking.dto.MovieDTO;
import com.shubhi.booking.dto_mappers.MovieMapper;
import com.shubhi.booking.exceptions.MovieNotFoundException;
import com.shubhi.booking.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

	@Autowired
    MovieRepository movieRepository;

	public List<MovieDTO> getMovies(int locationId) throws MovieNotFoundException {

		return MovieMapper.MAPPER.toMovieDTOs(movieRepository.getMoviesById(locationId));

	}
}
