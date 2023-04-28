package com.nutouchh.pract24.configuration;

import com.nutouchh.pract24.service.UsersDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UsersDetailsService usersDetailsService;

//    защиту всех запросов, кроме запросов на авторизацию и регистрацию, от
//    неавторизированных пользователей.
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/auth/login", "/auth/registration", "/error").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/auth/login")
                .loginProcessingUrl("/process_login")
                .defaultSuccessUrl("/home", true)
                .failureUrl("/auth/login?error");

    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(usersDetailsService)
                .passwordEncoder(getPasswordEncode());
    }

//    хеширование паролей алгоритмом Bcrypt
    @Bean
    public PasswordEncoder getPasswordEncode() {
        return new BCryptPasswordEncoder();
    }
}




// Пример из методички

//
//@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(HttpSecurity http) throws
//            Exception {
//        http.csrf().disable().cors().disable()
//                .authorizeRequests().antMatchers("/login",
//                        "/logout").permitAll()
//                .anyRequest().authenticated()
//                .and().formLogin()
//                .and().userDetailsService(userDetailsService());
//    }
//    public UserDetailsService userDetailsService() {
//        InMemoryUserDetailsManager userDetailsService = new
//                InMemoryUserDetailsManager();
//        userDetailsService.createUser(new User("user",
//                "password", List.of(new SimpleGrantedAuthority("ROLE_USER"))));
//        return userDetailsService;
//    }
//    @Bean
//    PasswordEncoder encoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }
//}
