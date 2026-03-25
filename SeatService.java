package com.selfstudy.library.services;

import com.selfstudy.library.dto.SeatDTO;
import com.selfstudy.library.entities.Seat;
import com.selfstudy.library.repositories.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeatService {

    @Autowired private SeatRepository seatRepository;

    public List<SeatDTO> getSeats() {
        return seatRepository.findAll().stream()
                .map(seat -> new SeatDTO(seat.getId(), seat.getSeatNumber(), seat.isAllocated(),
                        seat.getStudent() != null ? seat.getStudent().getId() : null))
                .collect(Collectors.toList());
    }

    public SeatDTO allocateSeat(SeatDTO dto) {
        Seat seat = seatRepository.findById(dto.getId()).orElseThrow();
        seat.setAllocated(true);
        seatRepository.save(seat);
        return dto;
    }

    public SeatDTO changeSeat(SeatDTO dto) {
        Seat seat = seatRepository.findById(dto.getId()).orElseThrow();
        seat.setAllocated(false);
        seatRepository.save(seat);
        return dto;
    }
}
