package com.example.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.LocalUser;

public interface LocalUserRepository extends JpaRepository<LocalUser, Integer> {
	//searchフォームで使用
	List<LocalUser> findByEmailContainingOrderByEmailAsc(String keyword);
}
