package com.selfstudy.library.controllers;

import com.selfstudy.library.dto.StudySessionDTO;
import com.selfstudy.library.services.StudySessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/study")
public class StudySessionController {

    @Autowired
    private StudySessionService studySessionService;

    @PostMapping("/checkin")
    public StudySessionDTO checkIn(@RequestBody StudySessionDTO dto) {
        return studySessionService.checkIn(dto);
    }

    @PostMapping("/checkout")
    public StudySessionDTO checkOut(@RequestBody StudySessionDTO dto) {
        return studySessionService.checkOut(dto);
    }
}
