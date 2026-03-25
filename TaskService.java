package com.selfstudy.library.services;

import com.selfstudy.library.dto.TaskDTO;
import com.selfstudy.library.entities.Task;
import com.selfstudy.library.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    @Autowired private TaskRepository taskRepository;

    public TaskDTO createTask(TaskDTO dto) {
        Task task = new Task();
        task.setDescription(dto.getDescription());
        task.setCompleted(dto.isCompleted());
        taskRepository.save(task);
        return dto;
    }

    public List<TaskDTO> getTasks() {
        return taskRepository.findAll().stream()
                .map(task -> new TaskDTO(task.getId(), task.getDescription(), task.isCompleted()))
                .collect(Collectors.toList());
    }
}
