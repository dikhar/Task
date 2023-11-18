package com.example.TaskManagement.repo;

import com.example.TaskManagement.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryTask extends JpaRepository<Task,String> {
}
