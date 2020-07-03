package com.miros.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.miros.entities.Engineer;

public class EngineerDetails implements UserDetails {

	private Engineer engineer;

	public EngineerDetails(Engineer engineer) {
		super();
		this.engineer = engineer;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return Collections.singleton(new SimpleGrantedAuthority("ENGINEER"));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return engineer.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return engineer.getName();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
