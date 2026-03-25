package com.selfstudy.library.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "organizations")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Organization {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String name;

    @Column(unique = true)
    private String uniqueOrganizationId;

    private int totalSeats;
    private int availableSeats;

    @OneToMany(mappedBy = "organization")
    private List<Student> students;
}
