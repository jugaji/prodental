package com.palhambra.prodentalserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetailsService;

	@Autowired
	RestAuthenticationEntryPoint restAuthenticationEntryPoint;

	@Autowired
	private MySavedRequestAwareAuthenticationSuccessHandler authenticationSuccessHandler;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint).and()
				.authorizeRequests().anyRequest().permitAll().and().rememberMe().and().formLogin()
				.successHandler(authenticationSuccessHandler)
				.failureHandler(new SimpleUrlAuthenticationFailureHandler()).and().logout().and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED).maximumSessions(5);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authProvider());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(11);
	}

	@Bean
	public DaoAuthenticationProvider authProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}

	@Bean
	public MySavedRequestAwareAuthenticationSuccessHandler mySuccessHandler() {
		return new MySavedRequestAwareAuthenticationSuccessHandler();
	}

	@Bean
	public SimpleUrlAuthenticationFailureHandler myFailureHandler() {
		return new SimpleUrlAuthenticationFailureHandler();
	}

}
