package com.example.TaskManagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    private String id;
    private String title;
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    private List<User>user;
}
