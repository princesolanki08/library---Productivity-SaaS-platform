package com.selfstudy.library.services;

import com.selfstudy.library.dto.PomodoroDTO;
import com.selfstudy.library.entities.PomodoroSession;
import com.selfstudy.library.repositories.PomodoroSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PomodoroService {

    @Autowired private PomodoroSessionRepository pomodoroSessionRepository;

    public PomodoroDTO startSession(PomodoroDTO dto) {
        PomodoroSession session = new PomodoroSession();
        session.setStartTime(dto.getStartTime());
        session.setStatus("WORK");
        pomodoroSessionRepository.save(session);
        return dto;
    }

    public PomodoroDTO breakSession(PomodoroDTO dto) {
        PomodoroSession session = pomodoroSessionRepository.findById(dto.getId()).orElseThrow();
        session.setStatus("BREAK");
        pomodoroSessionRepository.save(session);
        return dto;
    }

    public PomodoroDTO endSession(PomodoroDTO dto) {
        PomodoroSession session = pomodoroSessionRepository.findById(dto.getId()).orElseThrow();
        session.setEndTime(dto.getEndTime());
        session.setStatus("COMPLETED");
        pomodoroSessionRepository.save(session);
        return dto;
    }
}
