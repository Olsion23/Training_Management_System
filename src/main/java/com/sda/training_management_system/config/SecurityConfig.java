package com.sda.training_management_system.config;

import com.sda.training_management_system.dao.Role;
import com.sda.training_management_system.repositories.RoleRepository;
import com.sda.training_management_system.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SecurityConfig implements CommandLineRunner, WebMvcConfigurer {

    private final UserDetailsServiceImpl userService;
    private final RoleRepository roleRepository;
    @Value(value = "${frontendUrl}")
    private String frontendUrl;

    private static final String[] allowedUrls = new String[]
            {};

    public SecurityConfig(UserDetailsServiceImpl userDetailsService, RoleRepository roleRepository) {
        this.userService = userDetailsService;
        this.roleRepository = roleRepository;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userService).passwordEncoder(passwordEncoder());
        AuthenticationManager authenticationManager = authenticationManagerBuilder.build();
        http.authorizeHttpRequests(request -> {
                    request
                            .anyRequest().authenticated();
                })
                .authenticationManager(authenticationManager)
                .cors(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(frontendUrl)
                .allowedMethods("*");
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Override
    public void run(String... args) {
        if (!roleRepository.existsById("ROLE_ADMIN")){
            Role role = Role.builder()
                    .roleId("ROLE_ADMIN")
                    .build();
            roleRepository.save(role);
        }
        if (!roleRepository.existsById("ROLE_USER")){
            Role role = Role.builder()
                    .roleId("ROLE_USER")
                    .build();
            roleRepository.save(role);
        }
        if (!roleRepository.existsById("ROLE_LEADER")){
            Role role = Role.builder()
                    .roleId("ROLE_LEADER")
                    .build();
            roleRepository.save(role);
        }
    }

}
