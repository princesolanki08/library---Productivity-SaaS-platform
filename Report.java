package com.selfstudy.library.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "reports")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Report {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String period; // DAILY, WEEKLY, MONTHLY, YEARLY
    private int totalStudyTime;
    private int totalBreakTime;
    private int numberOfSessions;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
