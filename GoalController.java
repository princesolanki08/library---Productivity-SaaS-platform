package com.selfstudy.library.controllers;

import com.selfstudy.library.dto.GoalDTO;
import com.selfstudy.library.services.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goals")
public class GoalController {

    @Autowired
    private GoalService goalService;

    @PostMapping
    public GoalDTO createGoal(@RequestBody GoalDTO dto) {
        return goalService.createGoal(dto);
    }

    @GetMapping
    public List<GoalDTO> getGoals() {
        return goalService.getGoals();
    }
}
