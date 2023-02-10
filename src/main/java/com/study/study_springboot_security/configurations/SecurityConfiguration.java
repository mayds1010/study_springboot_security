package com.study.study_springboot_security.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    @Bean // 기본로그인하고싶으면 bean주석처리
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        // None using csrf protecton , jsp에 있던거 여기다 기입
        httpSecurity.csrf().disable();
        // 권한에 대한 부분 : url & roles : user url & roles
        // url, roles from Dao
        httpSecurity.authorizeRequests()
                // .antMatchers("/").authenticated() // 로그인 여부만 판단.
                // .antMatchers("/admin").access("hasRole('ROLE_ADMIN')") // 로그인 & 권한
                .antMatchers("/admin").authenticated()
                .antMatchers("/manager/*").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')")
                .antMatchers("/admin/*").access("hasRole('ROLE_ADMIN')")
                .anyRequest().permitAll(); // 설정한 URL 이외는 접근 가능(로그인 & 로그아웃).
        // 로그인에 대한 부분
        httpSecurity.formLogin().loginPage("/loginForm") // 로그인안됐을때 로그인할 수 있게끔
                .failureUrl("/loginForm?fail=true")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/");

        return httpSecurity.build();
    }

    @Bean
    public BCryptPasswordEncoder encoderPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
