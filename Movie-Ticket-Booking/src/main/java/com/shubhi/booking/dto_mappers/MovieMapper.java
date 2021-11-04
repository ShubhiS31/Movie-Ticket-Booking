package com.shubhi.booking.dto_mappers;

import java.util.List;

import com.shubhi.booking.dto.MovieDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.shubhi.booking.entity.Movie;
import com.shubhi.booking.exceptions.MovieNotFoundException;

@Mapper(componentModel = "spring")
public interface MovieMapper {

	MovieMapper MAPPER = Mappers.getMapper(MovieMapper.class);

	MovieDTO toMovieDTO(Movie movie) throws MovieNotFoundException;

	List<MovieDTO> toMovieDTOs(List<Movie> movies) throws MovieNotFoundException;

	Movie toMovie(MovieDTO movieDTO);

}
