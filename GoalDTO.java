package com.selfstudy.library.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GoalDTO {

    private Long id;
    private String type; // DAILY, WEEKLY, MONTHLY, YEARLY
    private String description;
    private boolean completed;
}