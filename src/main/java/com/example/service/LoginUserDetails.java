package com.example.service;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.entity.LocalUser;

//Spring Security
public class LoginUserDetails implements UserDetails {
	private static final long serialVersionUID = 1L;
	private LocalUser user;
	
	public LoginUserDetails(LocalUser user) {
		this.user = user;
	}
	
	public Integer getId() {
		//更新情報（作成者・更新者）設定に使用
		return user.getId();
	}
	
	public String getDisplayName() {
		//ログイン情報出力に使用
		return user.getName();
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		//実装しないので、固定でUSERを返却
		return Collections.singleton(new SimpleGrantedAuthority("USER"));
	}
	
	@Override
	public String getPassword() {
		return user.getPassword();
	}
	
	@Override
	public String getUsername() {
		//ログインIDにメールアドレスを使用
		return this.user.getEmail();
	}
	
	@Override
	public boolean isAccountNonExpired() {
		//実装しないので、固定でtrueを返却
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		//実装しないので、固定でtrueを返却
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		//実装しないので、固定でtrueを返却
		return true;
	}

	@Override
	public boolean isEnabled() {
		return user.isEnabled();
	}
}