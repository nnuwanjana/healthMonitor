package com.edoc.ConsultationService.configuration.security;

import com.edoc.ConsultationService.Constants.UserType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Setter @Getter @AllArgsConstructor
public class UserContext {

    private UUID userId;
    private String userName;
    private UserType userType;

    public UserContext() {

    }
}