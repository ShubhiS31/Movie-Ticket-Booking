package com.shubhi.booking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shubhi.booking.entity.Theater;

public interface TheaterRepository extends JpaRepository<Theater, Integer> {

	@Query("select  t from Mapping mt INNER JOIN Theater t ON t.theaterId=mt.theaterId where  mt.locationId=?1 AND mt.movieId=?2")
	public List<Theater> getTheatersRepository(int locationId, int movieId);

}
