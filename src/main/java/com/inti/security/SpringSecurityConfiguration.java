package com.inti.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.inti.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	CustomUserDetailsService uds;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		   http
	        .authorizeRequests()
	        	.antMatchers("/", "/login", "/creerClient").permitAll()
	            .anyRequest().authenticated()
	            .and()
	        .formLogin()
	        .loginPage("/login")
	        .defaultSuccessUrl("/", true)
	            .and()
	        .httpBasic()
	            .and()
	            .csrf().disable();
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.authenticationProvider(authProvider());
	}
	
	
	@Bean
	DaoAuthenticationProvider authProvider() {
		
		DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
		dao.setUserDetailsService(uds);
		dao.setPasswordEncoder(new BCryptPasswordEncoder());
		return dao;
	}

}
