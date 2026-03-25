package com.selfstudy.library.utils;

import java.util.UUID;

public class IdGenerator {

    public static String generateOrganizationId() {
        return "ORG-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    public static String generateStudentId() {
        return "STU-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    public static String generateSeatId() {
        return "SEAT-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    public static String generateLockerId() {
        return "LOCK-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}
