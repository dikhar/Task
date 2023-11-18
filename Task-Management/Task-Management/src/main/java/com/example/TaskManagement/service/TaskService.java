package com.example.TaskManagement.service;

import com.example.TaskManagement.dto.TaskRequest;
import com.example.TaskManagement.entity.Task;
import com.example.TaskManagement.entity.User;
import com.example.TaskManagement.repo.RepositoryTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class TaskService {
    @Autowired
    CacheManager cacheManager;
    @Autowired
    private RepositoryTask repositoryTask;

    public void CreateTask(TaskRequest task)
    {

        Task task1 = new Task();
        task1.setId(UUID.randomUUID().toString());
        List<User> userList = task.getUser()
                .stream()
                .map(this::mapTo)
                .toList();

        task1.setTitle(task.getTitle());
        task1.setDescription(task.getDescription());
        task1.setUser(userList);
        repositoryTask.save(task1);
    }

    private User mapTo(User userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setAge(userDto.getAge());
        return user;
    }

    public List<Task> getAllTasks() {
        return repositoryTask.findAll();
    }

    @Cacheable(value = "tasks")
    public Task getTask(String id)
    {
        return repositoryTask.findById(id).orElseThrow(() -> new NoSuchElementException("Task not found with ID: " + id));
    }

    public Cache getCacheTask(String cache)
    {
        return cacheManager.getCache(cache);
    }

    @CacheEvict(value = "tasks", key = "#taskId")
    public void deleteTask(String id)
    {
        repositoryTask.deleteById(id);
    }
}
