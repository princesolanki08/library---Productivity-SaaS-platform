package com.selfstudy.library.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "goals")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Goal {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type; // DAILY, WEEKLY, MONTHLY, YEARLY
    private String description;
    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
