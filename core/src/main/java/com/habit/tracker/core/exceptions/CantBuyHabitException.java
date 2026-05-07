package com.habit.tracker.core.exceptions;

public class CantBuyHabitException extends RuntimeException {
    public CantBuyHabitException(String message) {
        super(message);
    }
}

