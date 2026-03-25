package com.selfstudy.library.controllers;

import com.selfstudy.library.dto.SeatDTO;
import com.selfstudy.library.services.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seats")
public class SeatController {

    @Autowired
    private SeatService seatService;

    @GetMapping
    public List<SeatDTO> getSeats() {
        return seatService.getSeats();
    }

    @PostMapping("/allocate")
    public SeatDTO allocateSeat(@RequestBody SeatDTO seatDTO) {
        return seatService.allocateSeat(seatDTO);
    }

    @PutMapping("/change")
    public SeatDTO changeSeat(@RequestBody SeatDTO seatDTO) {
        return seatService.changeSeat(seatDTO);
    }
}
