package com.project.ToDo.ToDo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests((authorize)->{
                    authorize.requestMatchers(HttpMethod.POST,"/api/v1/**").hasRole("ADMIN");
                    authorize.requestMatchers(HttpMethod.PUT,"/api/v1/**").hasRole("ADMIN");
                    authorize.requestMatchers(HttpMethod.DELETE,"/api/v1/**").hasRole("ADMIN");
                    authorize.requestMatchers(HttpMethod.GET,"/api/v1/**").hasAnyRole("ADMIN","USER");
                    authorize.requestMatchers(HttpMethod.PATCH,"/api/v1/**").hasAnyRole("ADMIN","USER");
//                    This make public access to the GET RestAPI so that it can be accessed by anyone.
                    //authorize.requestMatchers(HttpMethod.GET,"/api/v1/**").permitAll();
                    authorize.anyRequest().authenticated();
                }).httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails ram = User.builder()
                .username("ram")
                .password(passwordEncoder().encode("1234"))
                .roles("USER")
                .build();

        UserDetails sam = User.builder()
                .username("sam")
                .password(passwordEncoder().encode("12345"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(ram,sam);
    }
}
