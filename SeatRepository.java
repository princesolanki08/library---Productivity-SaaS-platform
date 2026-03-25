package com.selfstudy.library.repositories;

import com.selfstudy.library.entities.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findByAllocated(boolean allocated);
}
