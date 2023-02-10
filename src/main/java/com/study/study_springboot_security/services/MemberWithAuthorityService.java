package com.study.study_springboot_security.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.study.study_springboot_security.daos.SharedDao;
import com.study.study_springboot_security.utils.CommonUtils;

import java.util.Map;

public class MemberWithAuthorityService {

    @Autowired
    SharedDao sharedDao;

    @Autowired
    CommonUtils commonUtils;

    public Object insert(Object dataMap) {
        String sqlMapId = "Memberwithauthority.insertWithUID";
        ((Map) dataMap).put("USERS_UID", commonUtils.getUniqueSequence());
        ((Map) dataMap).put("role", "ROLE USER");

        Object result = sharedDao.insert(sqlMapId, dataMap);
        return result;
    }
}
