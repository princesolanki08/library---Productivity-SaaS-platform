package com.selfstudy.library.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class SeatDTO {
    private Long id;
    private String seatNumber;
    private boolean allocated;
    private Long studentId;
}
