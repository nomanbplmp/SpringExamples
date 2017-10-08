package com.nk.example.reactive.controllers;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.TestingAuthenticationProvider;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.MapUserDetailsRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.session.Session;
import org.springframework.session.SessionRepository;
import org.springframework.web.reactive.config.CorsRegistry;

@SpringBootApplication
public class SpringReactiveWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringReactiveWebApplication.class, args);
	}
}

@Configuration
@EnableWebFluxSecurity
class SecurityConfiguration {

	@Bean
	UserDetailsRepository userDetailsRepository() {
		return new MapUserDetailsRepository(
				User.withUsername("admin").roles("ADMIN", "USER").password("admin").build());
	}

	@Bean
	SecurityWebFilterChain securityWebFilterChain(HttpSecurity httpSecurity) {
		return httpSecurity.authorizeExchange().and().authorizeExchange()
				.pathMatchers("*/login/*").permitAll().and().authorizeExchange()
				.pathMatchers("/**").authenticated().and()
				.build();

	}

	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**");
	}

	@Bean
	public AuthenticationProvider authenticatinProvider() {
		AuthenticationProvider auth = new CustomAuthenticationProvider();
		return auth;
	}

	@Bean
	public CustomerUserDetailService userDetailsService() {
		return new CustomerUserDetailService();
	}
}

class CustomerUserDetailService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		GrantedAuthority authority = new SimpleGrantedAuthority("ADMIN");
		System.out.println(username + " loaded");
		User user = new User(username, "****", Arrays.asList(new GrantedAuthority[] { authority }));
		return user;
	}

}

class CustomAuthenticationProvider extends TestingAuthenticationProvider {
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = authentication.getPrincipal().toString();

		System.out.println(username + " " + password);
		authentication.setAuthenticated(true);

		return super.authenticate(authentication);
	}
}

/*
 * @Configuration
 * 
 * @EnableWebFluxSecurity class SecurityConfiguration {
 * 
 * @Bean UserDetailsRepository userDetailsRepository() { return new
 * MapUserDetailsRepository( User.withUsername("admin").roles("ADMIN",
 * "USER").password("admin").build()); }
 * 
 * @Bean SecurityWebFilterChain securityWebFilterChain(HttpSecurity
 * httpSecurity) { return httpSecurity .authorizeExchange()
 * .anyExchange().hasRole("ADMIN").and() .build();
 * 
 * }
 * 
 * 
 * 
 * 
 * }
 */
