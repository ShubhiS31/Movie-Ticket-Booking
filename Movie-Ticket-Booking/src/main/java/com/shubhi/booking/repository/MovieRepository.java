package com.shubhi.booking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shubhi.booking.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

	@Query("select distinct m from Mapping mt inner join Movie m on m.movieId = mt.movieId where mt.locationId =?1")
	public List<Movie> getMoviesById(int locationId);

}
