package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.LocalUser;
import com.example.repositry.LocalUserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class LocalUserService {
	@Autowired
	private LocalUserRepository userRepository;
		
	public LocalUser save(LocalUser user) {
		return userRepository.save(user);
	}
		
	public List<LocalUser> findAll() {
		return userRepository.findAll();
	}
	
	public List<LocalUser> findUser(String keyword) {
		return userRepository.findByEmailContainingOrderByEmailAsc(keyword);
	}
	
	public Optional<LocalUser> findById(Integer id) {
		return userRepository.findById(id);
	}
	
	public void delete(Integer id) {
		userRepository.deleteById(id);
	}
}
