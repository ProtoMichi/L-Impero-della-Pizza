package it.uniroma3.siw.authentication;

import static it.uniroma3.siw.model.Credentials.ADMIN_ROLE;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AuthConfiguration {

	@Autowired
	private DataSource dataSource;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.authoritiesByUsernameQuery("SELECT username, ruolo from credentials WHERE username=?")
		.usersByUsernameQuery("SELECT username, password, 1 as enabled FROM credentials WHERE username=?");
	}

	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
		return authenticationConfiguration.getAuthenticationManager();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
		.csrf(csrf -> csrf.disable())
		.cors(cors -> cors.disable())
		.authorizeHttpRequests(auth -> auth
				// .requestMatchers("/**").permitAll()
				// chiunque (autenticato o no) può accedere alle pagine index, login, register, ai css e alle immagini
				.requestMatchers(HttpMethod.GET, "/", "/homepage", "/registrazione", "/css/**", "/images/**","/fonts/**","/pizza/{id}","/pizza","/ingrediente","/ingrediente/{id}","/recensione","/recensione/**").permitAll()
				.requestMatchers(HttpMethod.POST, "/registrazione", "/login").permitAll()
				// chiunque (autenticato o no) può mandare richieste POST al punto di accesso per login e register
				.requestMatchers(HttpMethod.GET, "/admin/**").hasAuthority(ADMIN_ROLE)
				.requestMatchers(HttpMethod.POST, "/admin/**").hasAuthority(ADMIN_ROLE)
				// tutti gli utenti autenticati possono accere alle pagine rimanenti 
				.anyRequest().authenticated()
				)
		// LOGIN: qui definiamo il login
		.formLogin(form -> form
				.loginPage("/login")
				.permitAll()
				.defaultSuccessUrl("/successo", true)
				.failureUrl("/login?error=true")
				)
		// LOGOUT: qui definiamo il logout
		.logout(logout -> logout
				// il logout è attivato con una richiesta GET a "/logout"
				.logoutUrl("/logout")
				// in caso di successo, si viene reindirizzati alla home
				.logoutSuccessUrl("/")
				.invalidateHttpSession(true)
				.deleteCookies("JSESSIONID")
				.clearAuthentication(true)
				.permitAll()
				);

		return http.build();
	}
}