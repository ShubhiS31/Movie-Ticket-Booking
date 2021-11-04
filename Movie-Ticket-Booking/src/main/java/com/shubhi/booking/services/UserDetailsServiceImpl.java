package com.shubhi.booking.services;

import java.util.Optional;

import com.shubhi.booking.dto.UserDTO;
import com.shubhi.booking.login_utility.UserPrincipal;
import com.shubhi.booking.rest.client.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
    RestClient restClient;

	@Override
	public UserDetails loadUserByUsername(String username) {
		Optional<UserDTO> user = restClient.getUser(username).getBody();
		return new UserPrincipal(user.orElseThrow(() -> new UsernameNotFoundException("User not found!!!")));

	}
}
