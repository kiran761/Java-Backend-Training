package com.example.BootSecurityInMemory.securityconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true)
public class EmpSecurityConfig extends WebSecurityConfigurerAdapter {

    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication().
                withUser("user").password("ki").roles("li")
                .and()
                .withUser("ki").password(";l").roles("kndl");
    }

    protected void configure(HttpSecurity http) throws Exception{

        http.csrf().disable().authorizeRequests()
                .antMatchers("/api/hello").permitAll()
                .antMatchers("/api/insert/**").authenticated()
                .and().httpBasic();
    }










































//    @Bean
//    public static PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//        http.csrf(
//                csrf->csrf.disable()).
//                authorizeHttpRequests((authorize)->authorize.anyRequest().authenticated()).httpBasic(Customizer.withDefaults());
//        return http.build();
//
//    }
//
//    @Bean
//    InMemoryUserDetailsManager userDetailsManager()
//    {
//        UserDetails userDetails= User.builder()
//                .username("employee")
//                .password(passwordEncoder().encode("mister"))
//                .roles("USER")
//                .build();
//        UserDetails adminDetails=User.builder()
//                .username("admin")
//                .password(passwordEncoder().encode("secret"))
//                .roles("ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(userDetails,adminDetails);
//
//    }


}

//@EnableWebSecurity
//@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true)
//
//@Override
//public EmpSecurityConfig extends