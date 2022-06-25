package com.edoc.ConsultationService.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter @Setter
public class APIError {

    public APIError(HttpStatus status, Throwable ex) {
        this.status = status;
        this.message = ex.getLocalizedMessage();
        this.timestamp = LocalDateTime.now();
    }

    private HttpStatus status;

    private String message;

    private LocalDateTime timestamp;
}
