package com.habit.tracker.core.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record HabitCreateRequestDto(
        @NotBlank(message = "Name cannot be empty")
        String name,
        @NotNull(message = "Points cannot be null")
        @Min(value = 0, message = "Points must be at least 0")
        Integer points,
        @NotNull(message = "Unlock cost cannot be null")
        @Min(value = 0, message = "Unlock cost must be at least 0")
        Integer unlockCost,
        @NotNull(message = "Days to master cannot be null")
        @Min(value = 1, message = "Days to master must be at least 1")
        Integer daysToMaster) {
}
