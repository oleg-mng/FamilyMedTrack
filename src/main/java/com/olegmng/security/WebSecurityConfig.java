package com.olegmng.security;


import com.olegmng.entity.Patient;
import com.olegmng.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.ArrayList;
import java.util.List;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    private PatientService patientService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/home").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(Customizer.withDefaults()

                )
                .logout((logout) -> logout.permitAll());

        return http.build();

    }

    @Bean
    public UserDetailsService userDetailsService() {
        List<Patient> patientList = patientService.getAllPatients();
        List<UserDetails> detailsList = new ArrayList<>();

        for (int i = 0; i < patientList.size(); i++) {

            UserDetails user =
                    User.withDefaultPasswordEncoder()
                            .username(patientList.get(i).getLogin())
                            .password(patientList.get(i).getPassword())
                            .build();

            detailsList.add(user);

        }
        return new InMemoryUserDetailsManager(detailsList);

    }
}

