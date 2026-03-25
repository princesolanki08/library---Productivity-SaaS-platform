package com.selfstudy.library.repositories;

import com.selfstudy.library.entities.Goal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoalRepository extends JpaRepository<Goal, Long> {
    List<Goal> findByStudentId(Long studentId);
}
