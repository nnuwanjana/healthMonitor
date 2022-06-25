package com.edoc.ConsultationService.Constants;

public enum UserType {
    DOCTOR ("doctor");

    private final String userType;
    UserType(String userType) {
        this.userType = userType;
    }
}
