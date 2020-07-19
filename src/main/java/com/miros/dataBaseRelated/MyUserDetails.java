package com.miros.dataBaseRelated;

import com.miros.entities.Engineer;
import com.miros.shipComponents.Engine;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MyUserDetails implements UserDetails {

    private Integer id;
    private String name;
    private String password;
    private String comment;
    private List<GrantedAuthority> roles;
    private Boolean active;

    public MyUserDetails(Engineer engineer) {
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
