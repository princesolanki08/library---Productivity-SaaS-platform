package com.selfstudy.library.controllers;

import com.selfstudy.library.dto.FeedbackDTO;
import com.selfstudy.library.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping
    public FeedbackDTO submitFeedback(@RequestBody FeedbackDTO dto) {
        return feedbackService.submitFeedback(dto);
    }

    @GetMapping
    public List<FeedbackDTO> getFeedback() {
        return feedbackService.getAllFeedback();
    }
}
