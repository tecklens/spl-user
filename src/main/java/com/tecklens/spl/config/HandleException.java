package com.tecklens.spl.config;

import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@ResponseBody
public class HandleException {
    Logger logger = LoggerFactory.getLogger(HandleException.class);
//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
//    public ResponseEntity<?> handleAllException(Exception ex, WebRequest request) {
//        logger.error("Error from :" + request.getContextPath() + " --Content: " + ex.getMessage());
//        ex.printStackTrace();
//        return ResponseEntity.badRequest();
//    }
//
//    @ExceptionHandler(BusinessException.class)
//    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
//    public ResultInfo<?> handleBusinessException(BusinessException ex, WebRequest request) {
//    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @ExceptionHandler({ RequestNotPermitted.class })
    @ResponseStatus(value = HttpStatus.TOO_MANY_REQUESTS, reason = "Số lần gọi vượt ngưỡng quy định")
    public void handleRequestNotPermitted() {
    }
}
