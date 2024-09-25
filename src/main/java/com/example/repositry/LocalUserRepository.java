package com.example.repositry;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.LocalUser;

public interface LocalUserRepository extends JpaRepository<LocalUser, Integer> {
	//ログインと重複チェックで使用
	Optional<LocalUser> findByEmail(String email);
	//boolean existsByEmail(String email);
	
	//一覧の初期表示で使用
	List<LocalUser> findAllByOrderByEmailAsc();
	
	//searchフォームで使用
	List<LocalUser> findByEmailContainingOrderByEmailAsc(String keyword);
}
