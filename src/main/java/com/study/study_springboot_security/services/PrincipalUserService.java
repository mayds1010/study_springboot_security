package com.study.study_springboot_security.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.study.study_springboot_security.configurations.PrincipalUser;
import com.study.study_springboot_security.daos.SharedDao;

@Service
public class PrincipalUserService implements UserDetailsService {// UserDetailsService는 필터체인에서 확인하고 옴

    @Autowired
    SharedDao sharedDao; // DB에 관한

    @Override
    // url /login 일때 spring scurity가 호출 (로그인에 관한)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // query select with ID
        String sqlMapId = "Memberwithauthority.selectByUID";
        Object usernameObj = username;
        Map<String, String> resultMap = (Map<String, String>) sharedDao.getOne(sqlMapId, usernameObj);
        // resultMap->PrincipalUser로 이동

        // session 등록
        PrincipalUser principalUser = new PrincipalUser(resultMap); // 생성자생성

        return principalUser;
    }

}
