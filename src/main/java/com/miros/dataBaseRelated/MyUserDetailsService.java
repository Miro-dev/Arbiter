package com.miros.dataBaseRelated;

import com.miros.entities.Engineer;
import com.miros.jpa.repositories.EngineerRepository;
import com.miros.shipComponents.Engine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    EngineerRepository engineerRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        System.out.println(name);

        Optional<Engineer> eng = engineerRepository.findByName(name);

        eng.orElseThrow(()->new UsernameNotFoundException("User Not Found!"));

        return eng.map(MyUserDetails::new).get();
    }
}


