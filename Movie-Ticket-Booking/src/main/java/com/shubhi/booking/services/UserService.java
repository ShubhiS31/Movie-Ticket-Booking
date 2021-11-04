package com.shubhi.booking.services;

import com.shubhi.booking.dto.UserDTO;
import com.shubhi.booking.dto_mappers.UserMapper;
import com.shubhi.booking.exceptions.UserNotFoundException;
import com.shubhi.booking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.shubhi.booking.entity.User;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public UserDTO getUser(String username) throws UserNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user == null)
			throw new UserNotFoundException("User not found .........");
		return (UserMapper.MAPPER.toUserDTO(user));
	}

	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);

	public boolean registerUser(UserDTO user) {
		User userDetails = userRepository.findByUsername(user.getUsername());
		if (userDetails != null) {
			return false;
		} else {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			userRepository.save(UserMapper.MAPPER.toUser(user));
		}
		return true;
	}

}
