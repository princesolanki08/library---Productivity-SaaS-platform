package com.selfstudy.library.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ReportDTO {
    private String period; // DAILY, WEEKLY, MONTHLY, YEARLY
    private int totalStudyTime;
    private int totalBreakTime;
    private int numberOfSessions;
}
