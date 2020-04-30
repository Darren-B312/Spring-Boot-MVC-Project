package com.sales.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@EnableWebSecurity // https://stackoverflow.com/a/61363621/13412894
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("user")
			.password("user")
			.roles("USER");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/addCustomer.html", "/addProduct.html", "/newOrder.html", "/showCustomers.html", "/showOrders.html", "/showProducts.html")
			.authenticated()
			.and()
			.formLogin();
		
		http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET) //http://websystique.com/spring-security/spring-security-4-logout-example/
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:index.html";
	}
	
}


// This is the implementation as found in the lab/lecture notes but I couldn't get it working
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter{ 
// @Override
// protected void configure(HttpSecurity http) throws Exception {
//  http
//    .authorizeRequests()
//    .antMatchers("/url1.html", "/url2.html", "url4.html")
//    .authenticated()
//    .and()
//    .formLogin();
//  }
//
//  @Bean
//  @Override
//  public UserDetailsService userDetailsService() {
//    UserDetails user = User.withDefaultPasswordEncoder()
//			.username("user")
//			.password("password")
//			.roles("USER")
//			.build();
//    return new InMemoryUserDetailsManager(user);
//  }
//}

