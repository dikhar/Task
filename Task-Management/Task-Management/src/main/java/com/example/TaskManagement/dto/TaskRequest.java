package com.example.TaskManagement.dto;

import com.example.TaskManagement.entity.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskRequest {
    private String title;
    private String description;
    private List<User> user;
}
