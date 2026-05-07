package com.habit.tracker.core.controller;

import com.habit.tracker.core.exceptions.*;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.annotations.NotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IncorrectDateException.class)
    public ResponseEntity<Map<String, Object>> handleIncorrectDateException(IncorrectDateException exception) {
        Map<String, Object> response = new HashMap<>();
        response.put("Message", exception.getMessage());
        response.put("Error", "Invalid argument");
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Map<String, Object>> handleAccessDeniedException(AccessDeniedException exception) {
        Map<String, Object> response = new HashMap<>();
        response.put("Message", exception.getMessage());
        response.put("Error", "Invalid argument");
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
    }

    @ExceptionHandler(HabitNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleHabitNotFoundException(HabitNotFoundException exception){
        Map<String, Object> response = new HashMap<>();
        response.put("Message", exception.getMessage());
        response.put("Error", "Resource not found");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(HabitAlreadyExistException.class)
    public ResponseEntity<Map<String, Object>> handleGeneralException(HabitAlreadyExistException exception) {
        Map<String, Object> response = new HashMap<>();
        response.put("error", "Resource already exist");
        response.put("message", exception.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(HabitAlreadyBoughtException.class)
    public ResponseEntity<Map<String, Object>> handleHabitAlreadyExistException(Exception exception) {
        Map<String, Object> response = new HashMap<>();

        response.put("error", "Habit already bought exception");
        response.put("message", exception.getMessage());
        response.put("timestamp", LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleEntityNotFoundException(EntityNotFoundException exception){
        Map<String, Object> response = new HashMap<>();
        response.put("error", "Data already exist");
        response.put("message", exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(CantBuyHabitException.class)
    public ResponseEntity<Map<String, Object>> handleCantBuyHabitException(CantBuyHabitException exception){
        Map<String, Object> response = new HashMap<>();
        response.put("error", "Cant Buy Habit");
        response.put("message", exception.getMessage());
        response.put("timestamp", LocalDateTime.now());
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneralException(Exception exception) {
        Map<String, Object> response = new HashMap<>();
        response.put("error", "Internal Server Error");
        response.put("message", exception.getMessage());
        response.put("timestamp", LocalDateTime.now());
        return ResponseEntity.internalServerError().body(response);
    }
}

