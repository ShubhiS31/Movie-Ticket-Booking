package com.shubhi.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shubhi.booking.entity.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

}
