package com.mabanque.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

@Configuration
@EnableWebSecurity
public class BanqueSecurity extends WebSecurityConfigurerAdapter
{
	
	@Autowired
	private DataSource dataSource;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	{
		/*auth.inMemoryAuthentication().withUser("admin").password("{noop}1234").roles("ADMIN","USER");
		auth.inMemoryAuthentication().withUser("user").password("{noop}1234").roles("USER");*/
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery("SELECT username as principal,password as credentials,active FROM users WHERE username = ?")
		.authoritiesByUsernameQuery("SELECT username as principal,role as role FROM users_roles WHERE username = ?")
		.rolePrefix("ROLE_")
		.passwordEncoder( new BCryptPasswordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception 
	{
		http.formLogin().loginPage("/mabanque/login");
		http.authorizeRequests().antMatchers("/mabanque/operations","/mabanque/consulterCompte").hasRole("USER");
		http.authorizeRequests().antMatchers("/mabanque/saveOperation").hasRole("ADMIN");
		http.exceptionHandling().accessDeniedPage("/mabanque/403");
	}
	
	@Bean
	public Pbkdf2PasswordEncoder pbkdPasswordEncoder()
	{
		Pbkdf2PasswordEncoder p = new Pbkdf2PasswordEncoder();
		
		return p;
	}
}
