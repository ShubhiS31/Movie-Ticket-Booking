package com.shubhi.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shubhi.booking.entity.Screen;

public interface ScreenRepository extends JpaRepository<Screen, Integer> {

	@Query("select st from Screen st where screenId=(select screenId from Mapping where movieId=?1  and theaterId=?2)")
	public Screen getScreen(int movieId, int theaterId);

}
