package com.selfstudy.library.controllers;

import com.selfstudy.library.dto.PomodoroDTO;
import com.selfstudy.library.services.PomodoroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pomodoro")
public class PomodoroController {

    @Autowired
    private PomodoroService pomodoroService;

    @PostMapping("/start")
    public PomodoroDTO startSession(@RequestBody PomodoroDTO dto) {
        return pomodoroService.startSession(dto);
    }

    @PostMapping("/break")
    public PomodoroDTO breakSession(@RequestBody PomodoroDTO dto) {
        return pomodoroService.breakSession(dto);
    }

    @PostMapping("/end")
    public PomodoroDTO endSession(@RequestBody PomodoroDTO dto) {
        return pomodoroService.endSession(dto);
    }
}
