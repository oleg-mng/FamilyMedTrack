package com.olegmng.security;


import com.olegmng.repository.PatientRepository;
import com.olegmng.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;
import java.util.Collection;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {



//    private final PatientDetailsService patientDetailsService;
//
//    public WebSecurityConfig(PatientDetailsService patientDetailsService) {
//        this.patientDetailsService = patientDetailsService;
//    }

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .formLogin(form -> form
//                        .loginPage("/login")
//                        .permitAll()
//                );
//        // ...
//        return null;


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

//    @Bean
//    public UserDetailsService userDetailsService() {
//        PatientDetailsService user =
//                (PatientDetailsService) User.withDefaultPasswordEncoder()
//                        .username(patientDetailsService.loadUserByUsername("Oleg").getUsername())
//                        .password(patientDetailsService.loadUserByUsername("Oleg").getPassword())
//                        .roles("USER")
//                        .build();
//
//        return new InMemoryUserDetailsManager((Collection<UserDetails>) user);
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user1 =
                User.withDefaultPasswordEncoder()
                        .username("Vika")
                        .password("p1")
//                        .roles("USER")
                        .build();
        UserDetails user2 =
                User.withDefaultPasswordEncoder()
                        .username("Anna")
                        .password("p2")
//                        .roles("USER")
                        .build();
        UserDetails user3 =
                User.withDefaultPasswordEncoder()
                        .username("Natalia")
                        .password("p3")
//                        .roles("USER")
                        .build();
        UserDetails user4 =
                User.withDefaultPasswordEncoder()
                        .username("Oleg")
                        .password("p4")
//                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(user1, user2, user3, user4);
    }

//    @Bean
//    public UserDetailsManager userDetailsService(DataSource dataSource) {
//        UserDetails user = User.builder()
//                .username("user")
//                .password("user")
//                .roles("USER")
//                .build();
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password("admin")
//                .roles("USER", "ADMIN")
//                .build();
//        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
//        users.createUser(user);
//        users.createUser(admin);
//        return users;
//    }


}

