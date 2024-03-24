package com.olegmng.security;


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
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/home").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(Customizer.withDefaults()
//                        (form) -> form
//                        .loginPage("/login")
//                        .permitAll()
                )
                .logout((logout) -> logout.permitAll());

        return http.build();

    }



    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user1 =
                User.withDefaultPasswordEncoder()
                        .username("Vika")
                        .password("p1")
                        .build();
        UserDetails user2 =
                User.withDefaultPasswordEncoder()
                        .username("Anna")
                        .password("p2")
                        .build();
        UserDetails user3 =
                User.withDefaultPasswordEncoder()
                        .username("Natalia")
                        .password("p3")
                        .build();
        UserDetails user4 =
                User.withDefaultPasswordEncoder()
                        .username("Oleg")
                        .password("p4")
                        .build();

        return new InMemoryUserDetailsManager(user1, user2, user3, user4);
    }

}

