package com.selfstudy.library.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class PomodoroDTO {
    private Long id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int workDuration;
    private int breakDuration;
    private String status; // WORK, BREAK, COMPLETED
}
