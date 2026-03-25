package com.selfstudy.library.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationDTO {

    private Long id;
    private String name;
    private String uniqueOrganizationId;
    private int totalSeats;
    private int availableSeats;

    private String username;
    private String password;
}