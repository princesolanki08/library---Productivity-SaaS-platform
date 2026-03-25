package com.selfstudy.library.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "fees")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Fee {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double depositAmount;
    private String status; // PAID / PENDING

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
