package com.study.study_springboot_security.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    @Bean // 기본로그인하고싶으면 bean주석처리
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        // None using csrf protecton jsp에 있던거
        httpSecurity.csrf().disable();
        // 권한에 대한 부분 : url & roles : user url & roles
        // url, roles from Dao
        httpSecurity.authorizeRequests()
                // .antMatchers("/").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
                // .antMatchers("/admin").access("hasRole('ROLE_ADMIN')") //(access)로그인 & 권한체크
                .antMatchers("/admin").authenticated() // 로그인 여부만 판단 ,기억하고 있음
                .anyRequest().permitAll(); // (permitAll) 설정한 URL 이외는 접근 가능.(로그인 & 로그아웃)

        // 로그인에 대한 부분
        httpSecurity.formLogin().loginPage("/loginForm") // 로그인안됐을때 로그인할 수 있게끔
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/");

        return httpSecurity.build();
    }
}
