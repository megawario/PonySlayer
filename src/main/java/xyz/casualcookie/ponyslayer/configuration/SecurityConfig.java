package xyz.casualcookie.ponyslayer.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Disable csrf for now
 * @author mpint
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter  {
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("Disabled security");
		http.csrf().disable();
	}

}
