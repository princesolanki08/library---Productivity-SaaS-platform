package com.selfstudy.library.controllers;

import com.selfstudy.library.dto.ReportDTO;
import com.selfstudy.library.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/daily")
    public ReportDTO getDailyReport() {
        return reportService.getDailyReport();
    }

    @GetMapping("/weekly")
    public ReportDTO getWeeklyReport() {
        return reportService.getWeeklyReport();
    }

    @GetMapping("/monthly")
    public ReportDTO getMonthlyReport() {
        return reportService.getMonthlyReport();
    }

    @GetMapping("/yearly")
    public ReportDTO getYearlyReport() {
        return reportService.getYearlyReport();
    }
}
