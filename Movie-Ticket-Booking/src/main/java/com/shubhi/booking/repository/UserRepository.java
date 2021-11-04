package com.shubhi.booking.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.shubhi.booking.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
