package com.miros.security;

import com.miros.entities.User;
import com.miros.jpa.repositories.entities.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {



        Optional<User> user = userRepository.findByName(name);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + name));

        User u = user.get();

        System.out.println("User is with pass / authority: " + u.getPassword() + " / " + u.getRoles());

        return user.map(MyUserDetails::new).get();
    }
}
