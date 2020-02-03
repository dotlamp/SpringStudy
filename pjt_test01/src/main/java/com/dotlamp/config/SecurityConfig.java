package com.dotlamp.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.dotlamp.security.CustomLoginSuccessHandler;
import com.dotlamp.security.CustomUserDetailsService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;


@Configuration
@EnableWebSecurity
@Log4j
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Setter(onMethod_ = @Autowired)
	private DataSource dataSource;
	
	@Bean
	public UserDetailsService customUserService() {
		return new CustomUserDetailsService();
	}
	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("ADMIN");
//		auth.inMemoryAuthentication().withUser("member").password("{noop}member").roles("MEMBER");
//	}
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		String queryUser = "select userid, userpw, enabled from tbl_member where userid = ?";
//		String queryDetails = "select userid, auth from tbl_member_auth where userid = ?";
//		
//		auth.jdbcAuthentication()
//				.dataSource(dataSource)
//				.passwordEncoder(passwordEncoder())
//				.usersByUsernameQuery(queryUser)
//				.authoritiesByUsernameQuery(queryDetails);
//	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/* mapper, domain */
		auth.userDetailsService(customUserService()).passwordEncoder(passwordEncoder());
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/* 권한 */
		http.authorizeRequests()
				.antMatchers("/sample/all").permitAll()
				.antMatchers("/sample/admin").access("hasRole('ROLE_ADMIN')")
				.antMatchers("/sample/member").access("hasRole('ROLE_MEMBER')");
		/* 로그인 */
//		http.formLogin().loginPage("/user/login").loginProcessingUrl("/login").successHandler(loginSuccessHandler());
		http.formLogin().loginPage("/user/login").loginProcessingUrl("/login");
		//.successHandler(loginSuccessHandler())
		/* 로그아웃 */
		http.logout().logoutUrl("/user/logout").invalidateHttpSession(true).deleteCookies("remember-me", "JSESSION_ID");
		
		http.rememberMe().key("dotlamp").tokenRepository(persistentTokenRepository()).tokenValiditySeconds(604800);
	}

	@Bean
	public AuthenticationSuccessHandler loginSuccessHandler() {
		return new CustomLoginSuccessHandler();
	}
	
	/* 패스워드 처리 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/* 자동 로그인 처리 */
	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl repo = new JdbcTokenRepositoryImpl();
		repo.setDataSource(dataSource);
		return repo;
	}


	

	
}
