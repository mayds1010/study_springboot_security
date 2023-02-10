package com.study.study_springboot_security.utils;

import java.util.UUID;

public class CommonUtils {
    public String getUniqueSequence() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
