//package com.selfstudy.library.services;
//
//import com.selfstudy.library.dto.GoalDTO;
//import com.selfstudy.library.entities.Goal;
//import com.selfstudy.library.repositories.GoalRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class GoalService {
//
//    @Autowired private GoalRepository goalRepository;
//
//    public GoalDTO createGoal(GoalDTO dto) {
//        Goal goal = new Goal();
//        
////        goal.setType(dto.getType());
////        goal.setDescription(dto.getDescription());
////        goal.setCompleted(dto.isCompleted());
//        goal.setStudent(null); // temporary fix
//        
//        goalRepository.save(goal);
//        
//        Goal savedGoal = goalRepository.save(goal);
//
//        return new GoalDTO(
//            savedGoal.getId(),
//            savedGoal.getType(),
//            savedGoal.getDescription(),
//            savedGoal.isCompleted()
//        );
////        return dto;
//        
//    }
//
//    public List<GoalDTO> getGoals() {
//        return goalRepository.findAll().stream()
//                .map(goal -> new GoalDTO(goal.getId(), goal.getType(), goal.getDescription(), goal.isCompleted()))
//                .collect(Collectors.toList());
//    }
//}


package com.selfstudy.library.services;

import com.selfstudy.library.dto.GoalDTO;
import com.selfstudy.library.entities.Goal;
import com.selfstudy.library.repositories.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GoalService {

    @Autowired
    private GoalRepository goalRepository;

    public GoalDTO createGoal(GoalDTO dto) {

        Goal goal = new Goal();
        goal.setType(dto.getType());
        goal.setDescription(dto.getDescription());
        goal.setCompleted(dto.isCompleted());
        goal.setStudent(null); // temporary (we'll fix later)

        Goal savedGoal = goalRepository.save(goal);

        return new GoalDTO(
                savedGoal.getId(),
                savedGoal.getType(),
                savedGoal.getDescription(),
                savedGoal.isCompleted()
        );
    }

    public List<GoalDTO> getGoals() {

        return goalRepository.findAll().stream()
                .map(goal -> new GoalDTO(
                        goal.getId(),
                        goal.getType(),
                        goal.getDescription(),
                        goal.isCompleted()
                ))
                .collect(Collectors.toList());
    }
}	