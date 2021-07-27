package com.zup.proposta.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication().withUser("user").password(passwordEncoder().encode("123456")).roles("ADDMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.httpBasic()
			.and()
			.authorizeRequests()
			.antMatchers("/biometrias").permitAll().anyRequest().authenticated()

			.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

			.and().csrf().disable();
		
		
		/*
		 * http.authorizeRequests(authorizeRequests -> authorizeRequests
		 * .antMatchers(org.springframework.http.HttpMethod.GET, "/api/propostas/**")
		 * .hasAuthority("SCOPE_propostas:read").antMatchers(HttpMethod.GET,
		 * "/api/cartoes/**")
		 * .hasAuthority("SCOPE_cartoes:read").antMatchers(HttpMethod.POST,
		 * "/api/cartoes/**")
		 * .hasAuthority("SCOPE_cartoes:write").antMatchers(HttpMethod.POST,
		 * "/api/propostas/**")
		 * .hasAuthority("SCOPE_propostas:write").anyRequest().authenticated())
		 * .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
		 */

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
