package com.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;
@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = {"com.security","com.config"})
public class SecurityConfig {
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;

    public SecurityConfig(PasswordEncoder passwordEncoder, UserDetailsService userDetailsService) {
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
    }

    @Autowired
    public void configure(AuthenticationManagerBuilder managerBuilder) throws Exception {
        managerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .authorizeRequests()
//                .anyRequest().authenticated()
                .antMatchers("/dashboard/admin/**").hasRole("ADMIN")
                .antMatchers("/dashboard/teacher/**").hasRole("TEACHER")
                .antMatchers("/dashboard/student/**").hasRole("STUDENT")
                .anyRequest().authenticated()
                // configuring our login form
                .and()
                .formLogin(form -> form
                        .loginPage("/login")
                        .permitAll()
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .loginProcessingUrl("/authenticateTheUser")
                        .permitAll()
                )
                .logout().permitAll();




//                .antMatchers("/admin").hasAuthority("ADMIN")
//                .antMatchers("/teacher").hasAuthority("TEACHER")
//                .antMatchers("/student").hasAuthority("STUDENT")
//                .and()
//                .formLogin()
//                .loginPage("/showMyCustomLoginPage")
//                .loginProcessingUrl("/authenticateTheUser")
//                .permitAll()
//                .and()
//                .logout().permitAll();

        return http.build();
    }












//    @Autowired
//    public void configure(HttpSecurity http) throws Exception{
//        http
//                .authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/showMyCustomLoginPage")
//                .loginProcessingUrl("/authenticateTheUser")
//                .permitAll();
//    }
}
