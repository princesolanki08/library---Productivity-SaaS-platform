//package com.selfstudy.library.services;
//
//import com.selfstudy.library.dto.FeedbackDTO;
//import com.selfstudy.library.entities.Feedback;
//import com.selfstudy.library.repositories.FeedbackRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class FeedbackService {
//
//    @Autowired
//    private FeedbackRepository feedbackRepository;
//
//    public FeedbackDTO submitFeedback(FeedbackDTO dto) {
//        Feedback feedback = new Feedback();
//        feedback.setMessage(dto.getMessage());
//        feedback.setSubmittedAt(LocalDateTime.now());
//        feedback.setUserId(dto.getUserId());
//        feedbackRepository.save(feedback);
//
//        return new FeedbackDTO(feedback.getId(), feedback.getMessage(), feedback.getSubmittedAt(), feedback.getUserId());
//    }
//
//    public List<FeedbackDTO> getFeedbackByUser(Long userId) {
//        return feedbackRepository.findByUserId(userId).stream()
//                .map(f -> new FeedbackDTO(f.getId(), f.getMessage(), f.getSubmittedAt(), f.getUserId()))
//                .collect(Collectors.toList());
//    }
//
//    public List<FeedbackDTO> getAllFeedback() {
//        return feedbackRepository.findAll().stream()
//                .map(f -> new FeedbackDTO(f.getId(), f.getMessage(), f.getSubmittedAt(), f.getUserId()))
//                .collect(Collectors.toList());
//    }
//}

package com.selfstudy.library.services;

import com.selfstudy.library.dto.FeedbackDTO;
import com.selfstudy.library.entities.Feedback;
import com.selfstudy.library.entities.User;
import com.selfstudy.library.repositories.FeedbackRepository;
import com.selfstudy.library.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private UserRepository userRepository;

    public FeedbackDTO submitFeedback(FeedbackDTO dto) {

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Feedback feedback = new Feedback();
        feedback.setMessage(dto.getMessage());
        feedback.setSubmittedAt(LocalDateTime.now());
        feedback.setUser(user);

        feedbackRepository.save(feedback);

        return new FeedbackDTO(
                feedback.getId(),
                feedback.getMessage(),
                feedback.getSubmittedAt(),
                feedback.getUser().getId()
        );
    }

    public List<FeedbackDTO> getFeedbackByUser(Long userId) {

        return feedbackRepository.findByUserId(userId).stream()
                .map(f -> new FeedbackDTO(
                        f.getId(),
                        f.getMessage(),
                        f.getSubmittedAt(),
                        f.getUser().getId()
                ))
                .collect(Collectors.toList());
    }

    public List<FeedbackDTO> getAllFeedback() {

        return feedbackRepository.findAll().stream()
                .map(f -> new FeedbackDTO(
                        f.getId(),
                        f.getMessage(),
                        f.getSubmittedAt(),
                        f.getUser().getId()
                ))
                .collect(Collectors.toList());
    }
}
