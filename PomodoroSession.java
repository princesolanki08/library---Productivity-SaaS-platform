package com.selfstudy.library.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "pomodoro_sessions")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class PomodoroSession {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int workDuration;
    private int breakDuration;
    private String status;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
