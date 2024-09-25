package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.entity.LocalUser;
import com.example.repositry.LocalUserRepository;

//Spring Security
@Service
public class LoginUserDetailsService implements UserDetailsService {
	@Autowired
	LocalUserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//ログインIDにメールアドレスを使用
		LocalUser user = userRepository.findByEmail(username)
				.orElseThrow(() -> new UsernameNotFoundException(username + " is not found."));
		return new LoginUserDetails(user);
	}
}
