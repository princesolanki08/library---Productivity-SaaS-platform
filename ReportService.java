//package com.selfstudy.library.services;
//
//import com.selfstudy.library.dto.ReportDTO;
//import com.selfstudy.library.entities.Report;
//import com.selfstudy.library.repositories.ReportRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ReportService {
//
//    @Autowired private ReportRepository reportRepository;
//
//    public ReportDTO getDailyReport() {
//        Report report = reportRepository.findAll().stream().findFirst().orElseThrow();
//        return new ReportDTO("DAILY", report.getTotalStudyTime(), report.getTotal




//
//package com.selfstudy.library.services;
//
//import com.selfstudy.library.dto.ReportDTO;
//import com.selfstudy.library.entities.Report;
//import com.selfstudy.library.repositories.ReportRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ReportService {
//
//    @Autowired
//    private ReportRepository reportRepository;
//
//    public ReportDTO getDailyReport() {
//
//        Report report = reportRepository
//                .findAll()
//                .stream()
//                .findFirst()
//                .orElseThrow();
//
//        return new ReportDTO(
//                "DAILY",
//                report.getTotalStudyTime(),
//                report.getTotalBreakTime(),
//                report.getNumberOfSessions()
//        );
//    }
//}


package com.selfstudy.library.services;

import com.selfstudy.library.dto.ReportDTO;
import com.selfstudy.library.entities.Report;
import com.selfstudy.library.repositories.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    public ReportDTO getDailyReport() {
        Report report = reportRepository.findAll().stream().findFirst().orElseThrow();

        return new ReportDTO(
                "DAILY",
                report.getTotalStudyTime(),
                report.getTotalBreakTime(),
                report.getNumberOfSessions()
        );
    }

    public ReportDTO getWeeklyReport() {
        Report report = reportRepository.findAll().stream().findFirst().orElseThrow();

        return new ReportDTO(
                "WEEKLY",
                report.getTotalStudyTime(),
                report.getTotalBreakTime(),
                report.getNumberOfSessions()
        );
    }

    public ReportDTO getMonthlyReport() {
        Report report = reportRepository.findAll().stream().findFirst().orElseThrow();

        return new ReportDTO(
                "MONTHLY",
                report.getTotalStudyTime(),
                report.getTotalBreakTime(),
                report.getNumberOfSessions()
        );
    }

    public ReportDTO getYearlyReport() {
        Report report = reportRepository.findAll().stream().findFirst().orElseThrow();

        return new ReportDTO(
                "YEARLY",
                report.getTotalStudyTime(),
                report.getTotalBreakTime(),
                report.getNumberOfSessions()
        );
    }
}