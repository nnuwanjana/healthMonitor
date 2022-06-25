package com.edoc.ConsultationService.exception;

import com.edoc.ConsultationService.vo.APIError;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    Logger logger = LogManager.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler({ BaseException.class })
    @ResponseBody
    public ResponseEntity<APIError> handleBaseException(BaseException ex) {
        APIError error = new APIError(HttpStatus.INTERNAL_SERVER_ERROR, ex);
        logger.error(error, ex);
        return new ResponseEntity<>(error, error.getStatus());
    }
}
