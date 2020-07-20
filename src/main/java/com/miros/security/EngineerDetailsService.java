package com.miros.security;

import java.text.MessageFormat;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.miros.entities.Engineer;
import com.miros.entities.attributes.AccessLevel;
import com.miros.jpa.repositories.EngineerRepository;
@Service("userDetailsService")
public class EngineerDetailsService implements UserDetailsService {

	@Autowired
	EngineerRepository er;

	@Autowired
	PasswordEncoder passwordEncoder;

	public String registerNewUserAccount(Engineer engineer) {
		String engName = engineer.getName();
		if (loadUserByUsername(engName) == null) {
			return "User Exists";
		} else {
			engineer.setPassword(passwordEncoder.encode(engineer.getPassword()));
//			engineer.setAccessLevel(new AccessLevel("ENGINEER"));
			er.save(engineer);
			return MessageFormat.format("User with name: {0} was created!", engName);
		}
	}


	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

		System.out.println(name);

		Optional<Engineer> eng = er.findByName(name);

		eng.orElseThrow(() -> new UsernameNotFoundException("User Not Found!"));

		return eng.map(EngineerDetails::new).get();
	}
}
