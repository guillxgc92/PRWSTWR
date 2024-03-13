package prw.stwr;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;


@SuppressWarnings({ "deprecation" })
@Configuration 
@EnableWebSecurity 

public class SecurityConfiguration {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	/*
	@Bean
    public static BCryptPasswordEncoder  passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
	*/
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(NoOpPasswordEncoder.getInstance());
    }
	
	@SuppressWarnings("removal")
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http, UserDetailsService userDetailsService) throws Exception {
		
		http.authorizeHttpRequests((authorize) -> authorize 
													.requestMatchers("/", "/index", "/login", "/register", "/community", "/information").permitAll()
													.requestMatchers("/video/**", "/js/**", "/styles/**", "/img/**").permitAll()
													.requestMatchers("/registerprocess", "/processLoginForm").permitAll()
													.anyRequest().authenticated())
		
			.httpBasic(withDefaults()).formLogin(form -> form
												     .loginPage("/login") 
												     .loginProcessingUrl("/login")
												     .failureUrl("/login?error=true")
												     .defaultSuccessUrl("/", true)
												     .permitAll())
													 .logout((logout) -> logout.logoutSuccessUrl("/").permitAll())
													 .csrf(csrf -> csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
													 .exceptionHandling().authenticationEntryPoint((request, response, authException) ->
													 { 
														 authException.printStackTrace();
														 response.sendRedirect("/");
													 }); //PERMITE QUE CUANDO ABRAMOS LA PÁGINA ESTA NO REDIRIJA AL USUARIO AL LOGIN POR DEAFAULT
		return http.build();
	}
}
