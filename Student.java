package com.selfstudy.library.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "students")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String studentId;

    private String name;

    @ManyToOne
    @JoinColumn(name = "organization_id")
    private Organization organization;

    @OneToOne(mappedBy = "student")
    private Seat seat;

    @OneToOne(mappedBy = "student")
    private Locker locker;

    @OneToOne(mappedBy = "student")
    private Fee fee;
}
