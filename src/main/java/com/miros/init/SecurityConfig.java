package com.miros.init;

import com.miros.security.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@ComponentScan(basePackages = "com.miros")
@EnableWebSecurity
@EnableJpaRepositories(basePackages = "com.miros")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

	protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/epanel").hasAnyRole("ENGINEER", "ADMIN")
                .antMatchers("/apanel").hasRole("ADMIN")
                .antMatchers("/").permitAll()
                .and().formLogin();
    }

	@Bean
    public NoOpPasswordEncoder getPasswordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
}


