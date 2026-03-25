package com.selfstudy.library.utils;

import com.selfstudy.library.entities.StudySession;
import com.selfstudy.library.entities.PomodoroSession;

import java.util.List;

public class ReportUtils {

    public static int calculateTotalStudyTime(List<StudySession> sessions) {
        return sessions.stream().mapToInt(StudySession::getTotalDuration).sum();
    }

    public static int calculateTotalBreakTime(List<StudySession> sessions) {
        return sessions.stream().mapToInt(StudySession::getBreakTime).sum();
    }

    public static int countPomodoroSessions(List<PomodoroSession> sessions) {
        return sessions.size();
    }
}
