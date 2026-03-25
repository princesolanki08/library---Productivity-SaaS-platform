package com.selfstudy.library.repositories;

import com.selfstudy.library.entities.StudySession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudySessionRepository extends JpaRepository<StudySession, Long> {
    List<StudySession> findByStudentId(Long studentId);
}
