package com.selfstudy.library.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class TaskDTO {
    private Long id;
    private String description;
    private boolean completed;
}
