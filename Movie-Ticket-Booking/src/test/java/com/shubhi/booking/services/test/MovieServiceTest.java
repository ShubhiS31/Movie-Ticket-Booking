
package com.shubhi.booking.services.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.shubhi.booking.dto.MovieDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.shubhi.booking.dto_mappers.MovieMapper;
import com.shubhi.booking.entity.Movie;
import com.shubhi.booking.exceptions.MovieNotFoundException;
import com.shubhi.booking.repository.MovieRepository;
import com.shubhi.booking.services.MovieService;

@SpringBootTest
class MovieServiceTest {

	@MockBean
	MovieRepository movieRepositoryMock;

	@InjectMocks
	MovieService movieServiceMock;

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getMoviesInBhopalAll() throws MovieNotFoundException {

		List<MovieDTO> movieDTO = new ArrayList<>();
		List<Movie> movies = new ArrayList<>();
		when(movieRepositoryMock.getMoviesById(Mockito.anyInt())).thenReturn(movies);
		when(MovieMapper.MAPPER.toMovieDTOs(movieRepositoryMock.getMoviesById(Mockito.anyInt()))).thenReturn(movieDTO);
		assertEquals(movieDTO, movieServiceMock.getMovies(Mockito.anyInt()));
	}

	@Test
	public void getMoviesInBhopalNull() throws MovieNotFoundException {
		when(movieRepositoryMock.getMoviesById(Mockito.anyInt())).thenReturn(null);
		when(MovieMapper.MAPPER.toMovieDTOs(null)).thenReturn(null);
		assertEquals(null, movieServiceMock.getMovies(Mockito.anyInt()));
	}

}
