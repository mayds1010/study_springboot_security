package com.study.study_springboot_security.configurations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class PrincipalUser implements UserDetails { // PrincipalUser는 로그인에 관한거임
    // 소스액션하고 return false를 true로 바꾸기

    private Map userInfo;
    private String memberName;

    public Map getUserInfo() {
        return userInfo;
    }

    public String getMemberName() {
        return memberName;
    }

    public PrincipalUser(Map userInfo) {
        this.userInfo = userInfo;
        int i = 1;
        this.memberName = (String) userInfo.get("NAME");
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        // 권한들
        Collection<GrantedAuthority> collections = new ArrayList<>();
        collections.add(new SimpleGrantedAuthority((String) userInfo.get("AUTHORITY")));
        return collections;
    }

    @Override
    public String getPassword() {
        // PASSWORD
        return (String) userInfo.get("PASSWORD");
    }

    @Override
    public String getUsername() {
        // ID
        return (String) userInfo.get("MEMBER_ID"); // 매퍼
    }

    @Override
    public boolean isAccountNonExpired() {
        // 계정 만료 여부
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // 계정 잠길 여부
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // 비밀번호 변경기간 만료
        return true;
    }

    @Override
    public boolean isEnabled() {
        // 휴먼계정 여부 확인
        return true;
    }

}
