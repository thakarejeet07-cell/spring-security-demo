package com.jeet.spring_security_demo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        // every request must be authenticated
        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());

        // keep the browser login form
        http.formLogin(Customizer.withDefaults());

        // allow Basic Auth (Postman)
        http.httpBasic(Customizer.withDefaults());

        // disable CSRF (fine for a learning project / stateless APIs, not for browser apps that use cookies)
        http.csrf(csrf -> csrf.disable());


//        http.csrf().disable()
//                .authorizeHttpRequests().anyRequest().authenticated()
//                .and()
//                .httpBasic();

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {

        UserDetails user1 = User
                .withDefaultPasswordEncoder()
                .username("jeet")
                .password("jeet123")
                .roles("USER")
                .build();

        UserDetails user2 = User
                .withDefaultPasswordEncoder()
                .username("admin")
                .password("admin123")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user1, user2);
    }
}
