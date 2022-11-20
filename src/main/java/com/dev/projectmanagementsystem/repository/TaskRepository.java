package com.dev.projectmanagementsystem.repository;

import com.dev.projectmanagementsystem.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}

