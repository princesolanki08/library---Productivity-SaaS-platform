package com.selfstudy.library.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "lockers")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Locker {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lockerNumber;
    private boolean allocated;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
