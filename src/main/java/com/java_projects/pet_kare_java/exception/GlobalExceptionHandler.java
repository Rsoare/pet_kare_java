package com.java_projects.pet_kare_java.exception;

import org.aspectj.bridge.Message;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private final MessageSource messages;

    public GlobalExceptionHandler(MessageSource messages) {
        this.messages = messages;
    }

    @ExceptionHandler({AppException.class})
    public ResponseEntity<Object> handleAppException(final AppException ex){

        final HashMap<String,String> returnObject = new HashMap<>();
        returnObject.put("message", ex.getMessage());

        return new ResponseEntity<>(returnObject, ex.getStatusCode());
    }
}
