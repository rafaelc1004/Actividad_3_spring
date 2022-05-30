package cl.security.java.configuracion;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http
				.authorizeRequests(authorize -> authorize 
					.mvcMatchers("/", "/nosotros", "/contacto").permitAll() // permite acceso sin autenticación 
					.mvcMatchers("/admin/index", "/admin/reporte").hasRole("ADMIN") 
					.anyRequest().authenticated()
				)
				.formLogin(form -> form
						.loginPage("/ingreso")
						
						.permitAll()
						)
				.logout(logout -> logout
						.logoutSuccessUrl("/ingreso")
						.logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET")))
				
				;

		}

		@Override
		public void configure(WebSecurity web) throws Exception {
			web.ignoring()
			.mvcMatchers("/img/**", "/css/**", "/js/**");
		}		
		
		
}
