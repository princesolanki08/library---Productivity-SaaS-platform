package com.selfstudy.library.repositories;

import com.selfstudy.library.entities.PomodoroSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PomodoroSessionRepository extends JpaRepository<PomodoroSession, Long> {
    List<PomodoroSession> findByStudentId(Long studentId);
}
