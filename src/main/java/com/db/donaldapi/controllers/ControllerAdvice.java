package com.db.donaldapi.controllers;

import com.db.donaldapi.models.dto.ExceptionMessageDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.time.LocalDateTime;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<ExceptionMessageDto> sqlException(SQLException e){
        return ResponseEntity.badRequest().body(
                new ExceptionMessageDto(e.getMessage(), LocalDateTime.now())
        );
    }
}
