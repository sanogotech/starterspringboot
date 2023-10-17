package com.macrosoft.starterjavaspringbootfull.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.config.annotation.web.builders.WebSecurity;

import com.macrosoft.starterjavaspringbootfull.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService userDetailsService;

/*
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    
	}
   
 */   
    
	
   @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("admin").password(passwordEncoder().encode("adminPass")).roles("ADMIN")
                .and()
                .withUser("user").password(passwordEncoder().encode("userPass")).roles("USER");
    }
 
    
    
   

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
				.antMatchers("/", "/h2-console/**/**").permitAll()
                .antMatchers("/admin").hasRole("ADMIN") // Exige le rôle ADMIN pour accéder à /admin
                .anyRequest().authenticated()
				.and()
                .headers().frameOptions().disable() // Désactiver la protection contre l'affichage dans un cadre pour H2 Console;
                .and()
            .formLogin()	
				 .loginPage("/loginecole")
				 .loginProcessingUrl("/loginformecole")
                .defaultSuccessUrl("/indexecole")
               .failureUrl("/loginecole?error=true")
               .permitAll()
                .and()
            .logout()
                .logoutSuccessUrl("/loginecole?logout=true")
                .and()
            .exceptionHandling()
                .accessDeniedPage("/access-denied");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	  @Override
  public void configure(WebSecurity web) {
    web.ignoring()
        .antMatchers("/resources/**", "/static/**","/sw.js/**","/css/**","/js/**","/icons/**","/images/**");
  }
}
