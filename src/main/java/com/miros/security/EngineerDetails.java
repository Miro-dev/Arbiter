package com.miros.security;

import com.miros.entities.Engineer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class EngineerDetails implements UserDetails {

	private Integer id;
	private String name;
	private String password;
	private String comment;
	private List<GrantedAuthority> roles;
	private Boolean active;

	public EngineerDetails(Engineer engineer) {
		this.id = engineer.getId();
		this.name = engineer.getName();
		this.password = engineer.getPassword();
		this.comment = engineer.getComment();
		this.roles = Arrays.stream(engineer.getRoles()
				.split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
		this.active = engineer.getActive();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return password;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return active;
	}
}


//public class EngineerDetails implements UserDetails {
//
//	private Engineer engineer;
//
//	public EngineerDetails(Engineer engineer) {
//		super();
//		this.engineer = engineer;
//	}
//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//
//		return Collections.singleton(new SimpleGrantedAuthority("ENGINEER"));
//	}
//
//	@Override
//	public String getPassword() {
//		// TODO Auto-generated method stub
//		return engineer.getPassword();
//	}
//
//	@Override
//	public String getUsername() {
//		// TODO Auto-generated method stub
//		return engineer.getName();
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//}
