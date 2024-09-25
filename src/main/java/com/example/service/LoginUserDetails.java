package com.example.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.entity.LocalUser;

//Spring Security
public class LoginUserDetails implements UserDetails {
	private LocalUser user;
	
	public LoginUserDetails(LocalUser user) {
		this.user = user;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return AuthorityUtils.createAuthorityList(user.getRole().getAuthName());
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
		//実装しないので、固定でtrueを返却
		return true;
	}
}