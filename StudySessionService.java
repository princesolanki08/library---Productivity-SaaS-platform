package com.selfstudy.library.services;

import com.selfstudy.library.dto.StudySessionDTO;
import com.selfstudy.library.entities.StudySession;
import com.selfstudy.library.repositories.StudySessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudySessionService {

    @Autowired private StudySessionRepository studySessionRepository;

    public StudySessionDTO checkIn(StudySessionDTO dto) {
        StudySession session = new StudySession();
        session.setCheckInTime(dto.getCheckInTime());
        studySessionRepository.save(session);
        return dto;
    }

    public StudySessionDTO checkOut(StudySessionDTO dto) {
        StudySession session = studySessionRepository.findById(dto.getId()).orElseThrow();
        session.setCheckOutTime(dto.getCheckOutTime());
        studySessionRepository.save(session);
        return dto;
    }
}
